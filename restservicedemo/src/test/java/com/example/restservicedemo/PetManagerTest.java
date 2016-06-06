package com.example.restservicedemo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.restservicedemo.domain.Pet;
import com.example.restservicedemo.service.PetManager;


public class PetManagerTest {
	
	
	PetManager petManager = new PetManager();
	
	private final static String NAME_1 = "Moly";
	private final static String SPECIES_1 = "Kot";
	
	private final static String NAME_2 = "Arryn";
	private final static String SPECIES_2 = "Krolik";
	
	private final static String NAME_3 = "Bartek";
	private final static String SPECIES_3 = "Pies";	
	@Test
	public void checkConnection(){
		assertNotNull(petManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Pet pet1 = new Pet(NAME_1, SPECIES_1);
		
		petManager.clearPets();
		assertEquals(1, petManager.addPet(pet1));
		
		List<Pet> pets = petManager.getAllPets();
		Pet petRetrieved = pets.get(0);
		
		assertEquals(NAME_1, petRetrieved.getName());
		assertEquals(SPECIES_1, petRetrieved.getSpecies());
		
	}
	
	@Test
	public void checkUpdating(){
		
		Pet pet1 = new Pet(NAME_1, SPECIES_1);
		Pet pet2 = new Pet(NAME_2, SPECIES_2);
		Pet pet3 = new Pet(NAME_3, SPECIES_3);
		
		petManager.clearPets();
		assertEquals(1, petManager.addPet(pet1));
		assertEquals(1, petManager.addPet(pet2));
		assertEquals(1, petManager.addPet(pet3));
		
		int id = petManager.addPetGetID(pet1);
		assertEquals(1, petManager.updatePet(id, pet2));
		
		List<Pet> pets = petManager.getAllPets();
		Pet petRetrieved = pets.get(3);
		
		assertEquals(NAME_2, petRetrieved.getName());
		assertEquals(SPECIES_2, petRetrieved.getSpecies());
		
	}
	@Test
	public void checkDeletePet(){
		
		Pet pet1 = new Pet(NAME_1, SPECIES_1);
		Pet pet2 = new Pet(NAME_2, SPECIES_2);
		Pet pet3 = new Pet(NAME_3, SPECIES_3);
		
		petManager.clearPets();
		assertEquals(1, petManager.addPet(pet1));
		assertEquals(1, petManager.addPet(pet2));
		assertEquals(1, petManager.addPet(pet3));
		assertEquals(1, petManager.addPet(pet3));
		assertEquals(1, petManager.addPet(pet3));
		
		assertEquals(1, petManager.deletePet(pet1));
		
		assertEquals(4, petManager.getAllPets().size());
		
		List<Pet> pets = petManager.getAllPets();
		Pet petRetrieved2 = pets.get(0);
		Pet petRetrieved3 = pets.get(1);
		
		assertEquals(NAME_2, petRetrieved2.getName());
		assertEquals(SPECIES_2, petRetrieved2.getSpecies());	
		
		assertEquals(NAME_3, petRetrieved3.getName());
		assertEquals(SPECIES_3, petRetrieved3.getSpecies());
	}
	@Test
	public void checkDeleting(){
		
		Pet pet1 = new Pet(NAME_1, SPECIES_1);
		Pet pet2 = new Pet(NAME_2, SPECIES_2);
		Pet pet3 = new Pet(NAME_3, SPECIES_3);
		
		petManager.clearPets();
		assertEquals(1, petManager.addPet(pet1));
		assertEquals(1, petManager.addPet(pet2));
		assertEquals(1, petManager.addPet(pet3));
		
		petManager.clearPets();
		
		assertEquals(0, petManager.getAllPets().size());
	}
	
	@Test
	public void checkSelectingByName(){
		
		Pet pet1 = new Pet(NAME_1, SPECIES_1);
		Pet pet2 = new Pet(NAME_2, SPECIES_2);
		
		petManager.clearPets();
		assertEquals(1, petManager.addPet(pet1));
		assertEquals(1, petManager.addPet(pet2));
		assertEquals(1, petManager.addPet(pet1));
		
		
		assertEquals(2, petManager.getPetsByName(NAME_1).size());
	}	

}
