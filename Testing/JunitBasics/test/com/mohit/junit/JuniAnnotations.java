package com.mohit.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JuniAnnotations {

	//Junit doesn't ensures the order of test execution
//	 private static final String BLUE = "\u001B[34m";
//	 private static final String RED = "\u001B[31m";
//	 private static final String ANSI_RESET = "\u001B[0m";
//	 private static final String GREEN = "\u001B[32m";
	
	
	
	
//	BeforeAll and AfterAll are class level methods so they must be static 
	@BeforeAll  // -> same as BeforeClass
	static void initSetup() {
		System.out.println( "Common Setup Before(runs once at start) starting any test");
	}
	
	@AfterAll  // -> same as AfterClass
	static void endSetup() {
		System.out.println( "Common Setup After(runs once at end) ending of all testt");
	}
	
	@BeforeEach // -> same as Before
	void beforeEach() {
		System.out.println( "Setup to be performed before each test");
	}
	
	@AfterEach  // -> same as After
	void afterEach() {
		System.out.println( "Clean-up to be performed after each test");
	}
	
	
	@Test
	void test1() {
		System.out.println("Test 1");
	}
	
	@Test
	void test2() {
		System.out.println("Test 2");
	}

	
	@Test
	void test3() {
		System.out.println("Test 3");
	}

	

}
