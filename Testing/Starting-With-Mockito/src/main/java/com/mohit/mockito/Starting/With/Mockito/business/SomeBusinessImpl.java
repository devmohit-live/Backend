package com.mohit.mockito.Starting.With.Mockito.business;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

public class SomeBusinessImpl {
	
	private DataService dataService;
	
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}


	public int findMax() {
		int[] data = dataService.retriveAllData();
		return Arrays.stream(data).boxed().reduce(Integer.MIN_VALUE, Math::max);
	}
}

interface DataService{
	int[] retriveAllData();
}
