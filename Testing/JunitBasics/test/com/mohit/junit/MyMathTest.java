package com.mohit.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath math = new MyMath();
	@Test
	void test() {
		//fail("Not yet implemented");
		// asset(expected, got)
		assertEquals(10, math.calculateSum(new int[] {1,2,3,4}));
	}
	
	@Test
	void tesWithEmptyArrayt() {
		assertEquals(0, math.calculateSum(new int[] {}));
		
	}

}
