package com.mohit.surveyapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.surveyapp.restdataapis.entity.UserDetails;


public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
	public List<UserDetails> findByRole(String role);
}
