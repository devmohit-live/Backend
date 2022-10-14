package com.mohit.surveyapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.ResponseEntity;

public class JSONAssertTest {

	@Test
	void jsonAssert_basic() throws JSONException {
		String expectedResponse = """ 
				{"id":                                 "Question1","description":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
				""";
		String actualResponse = """ 
				{"id":"Question1",
				"description":"Most Popular Cloud Platform Today",
				"options":["AWS","Azure","Google Cloud","Oracle Cloud"],
				"correctAnswer":"AWS"
				}
				""";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true); //match the complete structure
		
		//check if only few important fields should be there and matching exapmle
		
		String expectedResponse2 = """ 
				{"id":"Question1",
				"description":"Most Popular Cloud Platform Today",
				"correctAnswer":"AWS"
				}
				""";
		
//		[Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Fri, 14 Oct 2022 07:54:06 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]
		JSONAssert.assertEquals(expectedResponse2, actualResponse, false); //false: no exact matching
		
	}
}
