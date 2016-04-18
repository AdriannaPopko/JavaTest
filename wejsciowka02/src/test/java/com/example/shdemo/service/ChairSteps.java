package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import wejsciowka01.example.shdemo.domain.Chair;
import wejsciowka01.example.shdemo.domain.ChairManager;
import wejsciowka01.example.shdemo.domain.IList;

public class ChairSteps {
	
	private Chair chair;
	private ChairManager chm = new ChairManager(IList list);
	
	@Given("a chair")
	public void chairSetup(){
		chair = new Chair("bujane",50);
	}
	
	@When("set arguments to $chair and $50")
	public void setArguments(String a, double b){
		chair.setName(a);
		chair.setPrice(b);
	}
	
    @Then("adding should return $result")
	public void shouldAdd(int result){
		assertEquals(result, chair.addNewChair());
	}
    
    @Then("deleting should return $result")
  	public void shoulDelete(int result){
  		assertEquals(result, chair.deleteChair());
  	}

}
