package wejsciowka01.example.shdemo.domain;
import java.util.List;

public interface IList {
	
	public List<Chair> getAll();
	public Chair getByName(String title);
	boolean deleteChair(Chair chair);
	boolean addNewChair(Chair chair);

}
