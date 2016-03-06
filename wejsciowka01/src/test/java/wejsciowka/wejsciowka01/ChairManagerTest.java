package wejsciowka.wejsciowka01;

import static org.junit.Assert.*;
import org.junit.Test;



public class ChairManagerTest
{
    private ChairManager chm = new ChairManager();
    private ChairManager chmfilled = new ChairManager();
	private Chair chair1 = new Chair("Bujane", 5);
	private Chair chair2 = new Chair("Rozkladane", 3);
	
	@Test
	public void addCheck() {
		chm.addChair(chair1);
		chmfilled.addChair(chair1);
		assertArrayEquals(chm.getChair(), chmfilled.getChair());
	}
	
	@Test
    public void removeCheck() {
		chm.addChair(chair1);
		chm.addChair(chair2);
		chmfilled.addChair(chair1);
		chm.removeChair(chair2);
		assertArrayEquals(chm.getChair(), chmfilled.getChair());
    }

    @Test
    public void addCheckThorough() {
        chm.addChair(chair1);
        Chair[] expected = new Chair[]{chair1};
        assertArrayEquals(expected, chm.getChair());
    }

    @Test
    public void removeCheckThorough() {
       chm.addChair(chair1);
       chm.addChair(chair2);
       Chair[] expected = new Chair[]{chair2};
       chm.removeChair(chair1);
       assertArrayEquals(expected, chm.getChair());
    }
}