package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pet {
	
	private int id;
	private String name;
	private String species;	
	
	public boolean hasId(){
		return id > 0;
	}
	
	public Pet(String name, String species) {
		super();
		this.name = name;
		this.species = species;
	}
	
	public Pet() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	
}
