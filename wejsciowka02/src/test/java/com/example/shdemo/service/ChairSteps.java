package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import wejsciowka01.example.shdemo.domain.Chair;
import wejsciowka01.example.shdemo.domain.ChairManager;


public class ChairSteps {
	
	private ChairManager chairmanager;
	private Chair chair1 = new Chair("Name", 50);
	private Chair testchair = new Chair();
	
	@Given("a chair")
	public void bookSetup(){
		chairmanager = new ChairManager();
	}

	@When("received chair name $chairName")
	public void setArguments(String chairName){
		testchair.chairName = chairName;
	}
		
	@Then("addChair should add $result")
	public void shouldAdd(String result){
		chairmanager.addChair(testchair);
		assertEquals(result, chairmanager.chairs.get(0).getName());
	}
	
	@Then("deleteChair should delete $result")
	public void shouldDelete(String result){
		chairmanager.addChair(chair1);
		chairmanager.addChair(testchair);
		int size = chairmanager.getSize();
		
		chairmanager.deleteChair(testchair);
		int size2 = chairmanager.getSize();
		
		assertEquals(chair1.chairName, chairmanager.chairs.get(0).getName());
		assertEquals(size, size2+1);
	}
}