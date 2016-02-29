package com.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LiczbaRzymskaTests {
	LiczbaRzymska rzymska;
	@Before
	public void init()
	{
		rzymska = new LiczbaRzymska();
	}
	@Test
	public void liczba10() {
		rzymska.setLiczba(10);
		assertEquals("X",rzymska.toString());
	}
	@Test
	public void liczba53() {
		rzymska.setLiczba(53);
		assertEquals("LIII",rzymska.toString());
	}
	@Test
	public void liczbaNotNull() {
		rzymska.setLiczba(27);
		assertNotNull(rzymska.toString());
	}
	@Test
	public void LiczbaUjemna() {
		
		rzymska.setLiczba(-4);
		//nie mialem pomyslu jak ma sie zachowac program gdy sie poda 
		//liczbe ujemna to dalem by zwracalo null'a
		assertNull(rzymska.toString());
	}
}
