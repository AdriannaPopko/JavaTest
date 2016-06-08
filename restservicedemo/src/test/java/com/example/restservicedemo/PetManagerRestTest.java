package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.from;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.example.restservicedemo.domain.Pet;
import com.example.restservicedemo.service.PetManager;

import javax.ws.rs.core.MediaType;


public class PetManagerRestTest{

	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}

	PetManager pm = new PetManager();

	@Test
	public void getPet(){
		get("/pet/0").then().assertThat().body("name", equalTo("Molly"));

		Pet aPet = get("/pet/0").as(Pet.class);
		assertThat(aPet.getName(), equalToIgnoringCase("Molly"));
		//assertEquals("Kot", aPet.getSpecies());
	}

	@Test
	public void addPet(){

		//delete("/pet/").then().assertThat().statusCode(200);

		Pet aPet = new Pet("Molly", "Kot");
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(aPet).
				when().
				post("/pet/").then().assertThat().statusCode(201).body(containsString("Pet saved:"));
				//post("/pet/add").then().assertThat().statusCode(201);
		//System.out.println(aPet.getId());
		//get("/pet/0").then().assertThat().body("name", equalTo("Molly"));
		
	}

	@Test
	public void deletePet(){
		Pet petToDelete = get("/pet/0").as(Pet.class);
		pm.deletePet(petToDelete);
		get("/pet/0").then().assertThat().body("name", equalTo(null));
	}

	@Test
	public void getAllPets() {
		Pet aPet = new Pet("Molly", "Kot");
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(aPet).
				when().
				post("/pet/add").then().assertThat().statusCode(201);

		String pets = get("/pet/all").asString();
		List<Pet> returnedPets = from(pets).get("pet");
		assertNotNull(returnedPets);
	}
}