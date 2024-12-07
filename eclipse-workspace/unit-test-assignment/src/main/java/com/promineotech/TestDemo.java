package com.promineotech;

import java.util.*; // Necessary for Random class usage

public class TestDemo {
	public int addPositive(int a, int b) { // Add positive integers, throwing IllegalArgumentException otherwise
		if (a > 0 && b > 0) {
			return a + b;
			} else {
			throw new IllegalArgumentException("Both parameters have to be positive."); 
			}

	}
	public int addZero(int a, int b) { // Add ints with at least one comprising int zero
		if (a == 0 || b == 0) {
			return a+b;
		} else {
			throw new IllegalArgumentException("One parameter must be zero.");
		}
	}
	public int randomNumberSquared () { 
		int squarable = getRandomInt(); // Squarable variable int is able to be multiplied by itself
		return squarable * squarable;
	}
	
	public int getRandomInt() { // Static method declared, as it may be used in differing situations
		Random random = new Random ();
		return random.nextInt(10) + 1; // nextInt() goes from 0 until the number exclusive, so its square tops out at 100 
		// Return allows for other method to call it
	}
}