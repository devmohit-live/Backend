package com.mohit.surveyapp.restdataapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.surveyapp.restdataapis.entity.UserDetails;


public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
	
}
