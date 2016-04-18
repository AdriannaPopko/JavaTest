package wejsciowka01.example.shdemo.domain;
import java.util.ArrayList;
import java.util.List;


public class ChairManager {
	
	public List<Chair> chairs = new ArrayList<Chair>();
	
	public void addChair(Chair chair){
		chairs.add(chair);
	}
	
	public void deleteChair(Chair chair){
		chairs.remove(chair);
	}
	
	public int getSize(){
		return chairs.size();
	}
}
