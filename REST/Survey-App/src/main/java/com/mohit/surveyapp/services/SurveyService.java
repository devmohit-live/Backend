package com.mohit.surveyapp.services;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mohit.surveyapp.beans.Question;
import com.mohit.surveyapp.beans.Survey;

@Service
public class SurveyService {
	private static List<Survey> surveys = new ArrayList<>();

	static {
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey", "Description of the Survey", questions);

		surveys.add(survey);

	}

	public List<Survey> getAllSurveys() {
		return this.surveys;
	}

	public Survey getSurveyById(String id) {
		Optional<Survey> findFirst = surveys.stream().filter(s -> s.getId().equalsIgnoreCase(id)).findFirst();
		return findFirst.isPresent() ? findFirst.get() : null;
	}

	public List<Question> getSurveyQuestions(String id) {
		Survey survey = getSurveyById(id);
		if (survey == null)
			return null;
		List<Question> questions = survey.getQuestions();
		return questions;
	}

	public Question getSurveyQuestionById(String sid, String qid) {
		List<Question> surveyQuestions = getSurveyQuestions(sid);
		if (surveyQuestions == null)
			return null;
		Optional<Question> findFirst = surveyQuestions.stream().filter(q -> q.getId().equalsIgnoreCase(qid))
				.findFirst();
		return findFirst.isPresent() ? findFirst.get() : null;
	}

	public String addNewSurveyQuestion(String id, Question question) {
		question.setId(getRandomId()); //set auto id
		List<Question> surveyQuestions = getSurveyQuestions(id);
		if(surveyQuestions == null) return null;
		surveyQuestions.add(question);
		return question.getId(); //return that id for creating resource uri
	}

	private String getRandomId() {
		SecureRandom random = new SecureRandom();
		String randomId = new BigInteger(32, random).toString();
		return randomId;
	}

}
