package com.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	private int numberToFactor;
	private ArrayList<Integer> factors;
	private int divisor;
	
	public PrimeFactors(int number) {
		this.numberToFactor = number;
	}
	
	static List<Integer> generate(int number) {
		return new PrimeFactors(number).value();
	}
	
	private List<Integer> value() {
		init();
		addFactors();
		divisor = 3;
		
		while (canBeFactorized()) {
			addFactors();
			divisor = divisor + 2;
		}
		
		return factors;
	}

	private void init() {
		factors = new ArrayList<Integer>();
		divisor = 2;
	}
	
	private boolean canBeFactorized() {
		return numberToFactor > 1;
	}
	
	private void addFactors() {
		while (isDivisible()) {
			factors.add(divisor);
			reduceNumberToFactor();
		}
	}

	private void reduceNumberToFactor() {
		numberToFactor /= divisor;
	}

	private boolean isDivisible() {
		return numberToFactor % divisor == 0;
	}
	
}
