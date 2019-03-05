package com.prime;

import static com.prime.PrimeFactors.generate;
import java.util.Arrays;

import junit.framework.TestCase;


public class PrimeFactorsTest extends TestCase {
	
	public void testOne() throws Exception {
		assertTrue(generate(1).isEmpty());
	}
	
	public void testTwo() throws Exception {
		assertEquals(Arrays.asList(2), generate(2));
	}
	
	public void testThree() throws Exception {
		assertEquals(Arrays.asList(3), generate(3));
	}
	
	public void testFour() throws Exception {
		assertEquals(Arrays.asList(2,2), generate(4));
	}
	
	public void testFive() throws Exception {
		assertEquals(Arrays.asList(5), generate(5));
	}
	
	public void testSix() throws Exception {
		assertEquals(Arrays.asList(2,3), generate(6));
	}
	
	public void testEight() throws Exception {
		assertEquals(Arrays.asList(2,2,2), generate(8));  
	}
	  
	public void testNine() throws Exception {
		assertEquals(Arrays.asList(3,3), generate(9));
	}
}
