package com.mohit.surveyapp.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mohit.surveyapp.beans.Question;
import com.mohit.surveyapp.beans.Survey;
import com.mohit.surveyapp.services.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	private SurveyService service;

	@GetMapping("/surveys")
	public List<Survey> getAllSurveys() {
		return service.getAllSurveys();
	}

	@GetMapping("/surveys/{id}")
	public Survey getSurveysById(@PathVariable String id) {
		Survey survey = service.getSurveyById(id);
		if (survey == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Suvey having id : " + id + " doesn't exists");
		return survey;
	}

	@GetMapping("/surveys/{id}/questions")
	public List<Question> geSurveyQuestions(@PathVariable String id) {
		List<Question> questions = service.getAllSurveyQuestions(id);
		if (questions == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Suvey having id : " + id + " doesn't exists");
		return questions;
	}

	@GetMapping("/surveys/{sid}/questions/{qid}")
	public Question getSurveyQuestionsById(@PathVariable String sid, @PathVariable String qid) {
		Question question = service.getSurveyQuestionById(sid, qid);
		if (question == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Survey with the question id: " + qid + " doesn;t exists");
		return question;
	}

	@PostMapping("/surveys/{id}/questions")
	public ResponseEntity<Object> addSurveyQuestion(@PathVariable String id, @RequestBody Question question) {
		String qid = service.addNewSurveyQuestion(id, question);

		if (qid == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Survey Doesn't Exists or bad content");
		// surveys/{id}/questions/{qid}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{qid}").buildAndExpand(qid).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/surveys/{sid}/questions/{qid}")
	public ResponseEntity<Object> deleteSurveyQuestionsById(@PathVariable String sid, @PathVariable String qid) {
		String id = service.deleteSurveyQuestionById(sid, qid);
		if (id == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Survey or Question desn't Exists");
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/surveys/{sid}/questions/{qid}")
	public ResponseEntity<Object> updateSurveyQuestionsById(@PathVariable String sid, @PathVariable String qid, @RequestBody Question question) {
		String id = service.updateSurveyQuestionById(sid, qid, question);
		if (id == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Survey or Question desn't Exists");
		return ResponseEntity.noContent().build();
	}
	

}
