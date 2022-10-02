package com.mohit.surveyapp.beans;

import java.util.List;

public class Survey {
	private String id;
	private String description;
	private List<Question> questions;
	private String title;
	
	
	public Survey() {
	}

	

	public Survey(String id, String title, String description, List<Question> questions) {
		super();
		this.id = id;
		this.description = description;
		this.questions = questions;
		this.title = title;
	}



	public String getId() {
		return id;
	}


	public String getDescription() {
		return description;
	}



	public List<Question> getQuestions() {
		return questions;
	}



	public String getTitle() {
		return title;
	}



	@Override
	public String toString() {
		return "Survey [id=" + id + ", description=" + description + ", title=" + title + "]";
	}

	
}
