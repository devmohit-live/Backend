package com.mohit.mockito.Starting.With.Mockito.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class MockingTypes {
	
	
	List listMock = mock(List.class); //mocking list
	
	@Test
	void testSize() {
		when(listMock.size()).thenReturn(3);
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test
	void testMultipleReturns() {
		when(listMock.size()).thenReturn(1).thenReturn(2).thenReturn(5);
		assertEquals(1, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(5, listMock.size());
		assertEquals(5, listMock.size());
		assertEquals(5, listMock.size());
	}

	@Test
	void testWithSpecificParameter() {
		when(listMock.get(0)).thenReturn("String value");
		assertEquals("String value", listMock.get(0));
		assertEquals(null, listMock.get(5)); //for other by default Mockito returns null
	}

	@Test
	void testWithGenericParamter() {
		when(listMock.get(Mockito.anyInt())).thenReturn("Any String value");
		assertEquals("Any String value", listMock.get(Mockito.anyInt()));
		assertEquals("Any String value", listMock.get(5));
		assertEquals("Any String value", listMock.get(25));
	}
	
	
	@Test
	void testWithGenericParamters() {
		when(listMock.set(Mockito.anyInt(), Mockito.anyInt())).thenReturn("Any String value");
		assertEquals("Any String value", listMock.set(Mockito.anyInt(), Mockito.anyInt()));
	}

}
