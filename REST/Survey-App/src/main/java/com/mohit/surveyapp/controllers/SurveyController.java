package com.mohit.surveyapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mohit.surveyapp.beans.Question;
import com.mohit.surveyapp.beans.Survey;
import com.mohit.surveyapp.services.SurveyService;

@RestController
public class SurveyController {
	
	
	@Autowired
	private SurveyService service;
	

	@GetMapping("/surveys")
	public List<Survey> getAllSurveys(){
		return service.getAllSurveys();
	}
	
	@GetMapping("/surveys/{id}")
	public Survey getSurveysById(@PathVariable String id){
		 Survey survey = service.getSurveyById(id);
			if (survey == null)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Suvey having id : " + id + " doesn't exists");
			 return survey;
	}
	
	
	@GetMapping("/surveys/{id}/questions")
	public List<Question> geSurveyQuestions(@PathVariable String id){
			List<Question> questions = service.getSurveyQuestions(id);
			if (questions == null)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Suvey having id : " + id + " doesn't exists");
			 return questions;
	}
	
	@GetMapping("/surveys/{sid}/questions/{qid}")
	public Question geSurveyQuestionsById(@PathVariable String sid, @PathVariable String qid){
			Question question = service.getSurveyQuestionById(sid,qid);
			if (question == null)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey with the question id: "+qid+" doesn;t exists");
			 return question;
	}
	
	
}
