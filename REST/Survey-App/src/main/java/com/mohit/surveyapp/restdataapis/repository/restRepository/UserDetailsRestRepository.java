package com.mohit.surveyapp.restdataapis.repository.restRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mohit.surveyapp.restdataapis.entity.UserDetails;


public interface UserDetailsRestRepository extends PagingAndSortingRepository<UserDetails, Long>{
	public List<UserDetails> findByRole(String role);
}
