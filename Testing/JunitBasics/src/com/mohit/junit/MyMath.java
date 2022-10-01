package com.mohit.junit;

public class MyMath {

	public int calculateSum(int[] arr) {
		int sum = 0;
		for(int num : arr) sum+=num;
		return sum;
	}
}
