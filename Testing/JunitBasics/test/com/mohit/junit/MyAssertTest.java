package com.mohit.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	@Test
	void test() {
		List<String> list = List.of("Mohit","Shobhit","Ravi");
		assertEquals(true, list.contains("Mohit"));
		assertTrue(list.contains("Shobhit"));
		assertTrue(list.contains("Ravi"),"Somethign Went Wrong!");
		assertFalse(list.contains("Monster"),"Contains Monster");
		assertEquals(3, list.size(),"Size is greater than 3");
		assertNotNull(list,"List is null");
		List<Integer> list2 = null;
		assertNull(list2,"Not null");
		
		assertArrayEquals(new int[] {1,2,3,4}, new int[] {1,2,3,4}); 
//		assertArrayEquals(new int[] {1,2,3,4}, new int[] {1,2,3}); 
//		assertArrayEquals(new int[] {1,2,3,4}, new int[] {1,2,3,5}); 
	}

}
