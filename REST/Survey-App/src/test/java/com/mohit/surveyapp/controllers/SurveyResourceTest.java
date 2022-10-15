package com.mohit.surveyapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mohit.surveyapp.beans.Question;
import com.mohit.surveyapp.services.SurveyService;

//This is an unit test

@WebMvcTest(controllers = SurveyController.class) // telling spring to load context for this controller test
class SurveyResourceTest {
	// Testing SurveyController using SurveySeviceBean mocks

	@MockBean
	private SurveyService service;

	@Autowired
	private MockMvc mockMvc;
	// Mock -> service.getSurveyQuestionById(sid, qid); service
	// Fire GET req to => /surveys/Survey1/questions/Question1

	private String GENERIC_QUESTION_URL = "http://localhost:8080/surveys/Survey1/questions/";
	private String SPECIFIC_QUESTION_URL = "http://localhost:8080/surveys/Survey1/questions/Question1/";

	@Test
	void getSurveyQuestionsById_404Scenario() throws Exception {
		RequestBuilder builder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(builder).andReturn();

//		System.out.println(mvcResult.getResponse().getContentAsString());
//		System.out.println(mvcResult.getResponse().getStatus());
		assertEquals(404, mvcResult.getResponse().getStatus());
	}

	@Test
	void getSurveyQuestionsById_basicScenario() throws Exception {

		String expectedResponse = """
				{
					"id":"Question1",
					"description":"Most Popular Cloud Platform Today",
					"options":["AWS","Azure","Google Cloud","Oracle Cloud"],
					"correctAnswer":"AWS"
				}
				""";

		RequestBuilder builder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);

		// mocking service using mockito

		Question question = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		when(service.getSurveyQuestionById("Survey1", "Question1")).thenReturn(question);

		MvcResult mvcResult = mockMvc.perform(builder).andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
		JSONAssert.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	void addSurveyQuestion_basicScenario() throws Exception {
		String requestBody = """
				{
					"description": "Most Popular Language",
					"options":["Java", "Python", "C++", "GO"],
					"correctAnswer": "Java"
				}
				""";
		
		//Mock => service.addNewSurveyQuestion(surveyId, question);
		when(service.addNewSurveyQuestion(anyString(), any())).thenReturn("SOME_ID");
		
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.post(GENERIC_QUESTION_URL)
				.accept(MediaType.APPLICATION_JSON)
				.content(requestBody).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(201, response.getStatus());
		String locationHeader = response.getHeader("Location");
//		System.out.println(locationHeader);
		assertTrue(locationHeader.contains("http://localhost:8080/surveys/Survey1/questions/SOME_ID"));
	}
}
