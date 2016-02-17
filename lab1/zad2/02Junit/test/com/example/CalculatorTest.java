package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculatorTest {
	
	private Calculator calc = new Calculator();
	
	@Test
	public void addCheck(){
		
		assertEquals(5.6, calc.add(3.3, 2.3),0); 
	}
	
	@Test
	public void subCheck(){
		
		assertEquals(1, calc.sub(3.3, 2.3),0); 
	}
	
	@Test
	public void multiCheck(){
		
		assertEquals(7.13, calc.multi(3.1, 2.3),0); 
	}
	
	@Test
	public void divCheck(){
		
		assertEquals(2.75, calc.div(11, 4),0); 
	}
	
	@Test
	public void greaterCheck(){
		
		assertTrue(calc.greater(3, 2)); 
		assertFalse(calc.greater(2, 3)); 
	}
	
	@Test
	public void divZeroCheck(){
		
		try{
			calc.div(1, 0);
			fail ("Nie dziel przez 0!");
			} 
			catch (ArithmeticException e) {}
	}
	

}
