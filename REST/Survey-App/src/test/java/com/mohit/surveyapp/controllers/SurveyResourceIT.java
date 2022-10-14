package com.mohit.surveyapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

//Integration Test
//use random port as 8080 is being used by main application

//SpringBootTest => loads complete context for testing

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {
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

	@Autowired
	private TestRestTemplate template;
	private final String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";

	@Test
	void getSurveyQuestionsById_basicScenario() {

		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);
		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());
		String expectedResponse = """ 
				{"id":"Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
				""";
		assertEquals(expectedResponse.trim(), responseEntity.getBody()); //not recommeded
		
		
//		[Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Fri, 14 Oct 2022 07:54:06 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]
		
	}
}
