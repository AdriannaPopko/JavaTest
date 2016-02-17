package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class NWDTest {
		private NWD najw = new NWD();
		
		@Test
		public void Check1(){
			assertEquals(3, najw.nwd(9, 3));
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void Check2(){
			assertEquals(7, najw.nwd(-7, 7));
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void Check3(){
			assertEquals(0, najw.nwd(0, 0));
		}
		
		@Test
		public void Check4(){
			assertEquals(2, najw.nwd(2, 0));
		}
}
