package com.mohit.surveyapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

// This is an Integration Test
//use random port as 8080 is being used by main application

//SpringBootTest => loads complete context for testing

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {

	@Autowired
	private TestRestTemplate template;
	private final String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";
	private final String GENERIC_QUESTION_URL = "/surveys/Survey1/questions/";

	@Test
	void getSurveyQuestionsById_basicScenario() throws JSONException {

		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);

		String expectedResponse = """
				{
						"id": "Question1",
						"description": "Most Popular Cloud Platform Today",
						"options": [
						"AWS",
						"Azure",
						"Google Cloud",
						"Oracle Cloud"
						],
						"correctAnswer": "AWS"
					}
				""";

		// check for status code
//		assertEquals(200, responseEntity.getStatusCodeValue());
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		// check for headers : Content-Type:"application/json",
		// header returns a list
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		// check body
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

	}

	@Test
	void geSurveyQuestions_basicTest() throws JSONException {
		var expectedResponse = """
						[
							{
								"id": "Question1",
								"description": "Most Popular Cloud Platform Today",
								"correctAnswer": "AWS"
							},
							{
								"id": "Question2",
								"description": "Fastest Growing Cloud Platform",
								"correctAnswer": "Google Cloud"
							},
							{
								"id": "Question3",
								"description": "Most Popular DevOps Tool",
								"correctAnswer": "Kubernetes"
							}
							]
				""";
		ResponseEntity<String> responseEntity = template.getForEntity(GENERIC_QUESTION_URL, String.class);
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody().toString(), false);

	}

	@Test
	void addSurveyQuestion_basicTest() {

		String body = """
				{
					"description": "Most Popular Language",
					"options":["Java", "Python", "C++", "GO"],
					"correctAnswer": "Java"
				},
				""";

		// setting up resquest body
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		HttpEntity<String> httpEntity = new HttpEntity<String>(body, headers);
		ResponseEntity<String> responseEntity = template.postForEntity(GENERIC_QUESTION_URL, httpEntity, String.class);
		
		//or
//		ResponseEntity<String> responseEntity = template.exchange(GENERIC_QUESTION_URL, HttpMethod.POST, httpEntity, String.class);
	
		
		// response : 201, location of newly created resource
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		
		// revert back the changes : as test seq is not predictable
		String locationHeader = responseEntity.getHeaders().get("Location").get(0);
		template.delete(locationHeader);

	}
}
