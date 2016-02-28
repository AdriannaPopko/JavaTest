package zad3.zad3;

import org.junit.Test;

public class LiczbaRzymskaTest {
	
	private LiczbaRzymska rzymska = new LiczbaRzymska(liczba);

	@Test
	public void rzymCheck(){
		
		assertEquals("I" ,rzymska.toString(1));
		
	}
}
