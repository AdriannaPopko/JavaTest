package wejsciowka.wejsciowka01;

import java.util.ArrayList;
import java.util.List;


public class ChairManager {
	private List<Chair> chairs = new ArrayList<Chair>();
	
	public void addChair(Chair chair) {
		chairs.add(chair);
	}
	
	public void removeChair(Chair chair) {
		chairs.remove(chair);
	}
	
	public Chair[] getChair() {
		Chair[] array = chairs.toArray(new Chair[chairs.size()]);
		return array;
	}
}