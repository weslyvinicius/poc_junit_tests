package com.academy.tests.pocunittest.mocks;

public class CalculatorMocks {

	public int add(int a, int b) {
		int result = a + b;
		log(result);
		return result;
	}

	public void log(int message) {
		System.out.println("Log: " + message);
	}

	public void log(String message) {
		System.out.println("Log: " + message);
	}

}
