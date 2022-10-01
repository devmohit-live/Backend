package com.mohit.mockito.Starting.With.Mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//Another way of defining Mock and auto injecting all mock dependecies into a depedent class using annotations
// to sucessfully use those annotations we have to Annotately extend Mockito
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class) //without this @mock annotations will not work
class MockitoAnnotations {

	@Mock
	private  DataService mock; //there can be n no of mocks
	
	@InjectMocks // all n mocks will be injected into dependent class
	private SomeBusinessImpl businessImpl;


	@Test
	void test() {

		when(mock.retriveAllData()).thenReturn(new int[] { 25, -9, 11, 10 });
		assertEquals(25, businessImpl.findMax());
	}

	@Test
	void testWithEmptyArray() {

		when(mock.retriveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findMax());
	}

	@Test
	void testWithSinglElement() {

		when(mock.retriveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, businessImpl.findMax());
	}
	
	
	@Test
	void testWithAllNegative() {

		when(mock.retriveAllData()).thenReturn(new int[] { -1,-1,-1,-9999,-56 });
		assertEquals(-1, businessImpl.findMax());
	}

}
