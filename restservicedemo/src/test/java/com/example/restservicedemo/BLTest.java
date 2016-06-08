package com.example.restservicedemo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Pet;
import com.example.restservicedemo.service.PetManager;

public class BLTest {
	private static Pet p1;
	private static Pet p2;
	private static Pet p3;
	
	private static PetManager pm = new PetManager();
	@BeforeClass
	public static void setUp() {
		p1 = new Pet("Molly", "Kot");
		p2 = new Pet("Arryn", "Krolik");
		p3 = new Pet("Bartek", "Pies");
	}
	@Before
	@After
	public void cleanTable() {
		pm.clearPets();
	}
	@Test
	public void addPet() {
		assertEquals(1, pm.addPet(p1));
		
	}	
	@Test
	public void getAllPets() {

		pm.addPet(p1);
		pm.addPet(p2);
		pm.addPet(p3);

		List<Pet> pets = new ArrayList<>();

		pets = pm.getAllPets();

		assertEquals(3, pets.size());
		assertNotEquals(pets.get(0), pets.get(1));
		assertNotEquals(pets.get(1), pets.get(2));

		assertEquals(p1.getName(), pets.get(0).getName());
		assertEquals(p2.getName(), pets.get(1).getName());
		assertEquals(p3.getName(), pets.get(2).getName());
	}
	
}
