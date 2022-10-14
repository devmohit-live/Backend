package com.mohit.surveyapp.restdataapis.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String role;
	
	
	
	public UserDetails() {
	}


	public UserDetails(String name, String role) {
		super();
		this.role = role;
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public String getRole() {
		return role;
	}


	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	
	
}
