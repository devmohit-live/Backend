package com.mohit.mockito.Starting.With.Mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SomeBusinessImplTest {
	
	private static SomeBusinessImpl businessImpl;
	private static DataService mock ;
	@BeforeAll
	static void init() {
		mock = mock(DataService.class);//mocks interface or class
		businessImpl = new SomeBusinessImpl(mock);
//		businessImpl = new SomeBusinessImpl(new DataServiceStub());
	}
	
	@Test
	void test() {
//		assertEquals(25, businessImpl.findMax()); 
		//tell mok=ckito that whever retriveData is called retun an array with some data
		when(mock.retriveAllData()).thenReturn(new int[] {25,-9,11,10});
		assertEquals(25, businessImpl.findMax());
	}
	
	@Test
	void testWithEmptyArray() {
//		assertEquals(Integer.MIN_VALUE, new SomeBusinessImpl(new DataServiceStub2()).findMax()); 
		when(mock.retriveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findMax());
	}
	
	@Test
	void testWithSinglElement() {
//		assertEquals(Integer.MIN_VALUE, new SomeBusinessImpl(new DataServiceStub2()).findMax()); 
		when(mock.retriveAllData()).thenReturn(new int[] {5});
		assertEquals(5, businessImpl.findMax());
	}

}

// Now using Mocks





//using Stubs
class DataServiceStub implements DataService{

	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {25,-9,11,10};
	}
	
}

// Problem : for every new case we have to create a new Stub Overrding the abstract functions.
// can rely on single instance of BusinessImp for very test we have to create new BusinessImp instance with new Stub
// No use of @BeforeAll thing

class DataServiceStub2 implements DataService{

	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {};
	}
	
}

