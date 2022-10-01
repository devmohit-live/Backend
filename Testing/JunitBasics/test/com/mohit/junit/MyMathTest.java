package com.mohit.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath math = new MyMath();
	@Test
	void test() {
		//fail("Not yet implemented");
		int[] nums = {1,2,3,4};
		// asset(expected, got)
		assertEquals(10, math.calculateSum(nums));
	}
	
	@Test
	void tesWithEmptyArrayt() {
		int[] nums = {};
		assertEquals(0, math.calculateSum(nums));
		
	}

}
