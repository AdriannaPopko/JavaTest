package wejsciowka01.example.shdemo.service;
import java.util.ArrayList;
import java.util.List;

import wejsciowka01.example.shdemo.domain.IList;
import wejsciowka01.example.shdemo.domain.Chair;

public class ChairManager {
	
	//public List<Chair> lamps= new ArrayList<Lamp>();
	
	public IList list;
	
	public ChairManager(IList list)
	{
		this.list = list;
		
	}
	
	public boolean addNewChair(Chair chair)
	{
		return list.addNewChair(chair);
	}
	
	public boolean deleteChair(Chair chair)
	{
		return list.deleteChair(chair);
		
	}
	
	public List<Chair> getAllChairs(){
		return list.getAll();
	}
	
	public Chair getByName(String chairName){
		return list.getByName(chairName);
	}
	

}
