package com.example.restservicedemo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restservicedemo.domain.Pet;
import com.example.restservicedemo.service.PetManager;

@Path("pet")
public class PetFakeRESTService {	
	
	private PetManager pm = new PetManager();
	
	@GET
	@Path("/{petId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pet getPet(@PathParam("petId") int id){
		Pet pet = pm.getPet(id);
		return pet;
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Pet pet) {
 
		pm.addPet(pet);
		return Response.status(201).entity("Pet").build(); 
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNewCar(Pet pet) {
		Pet petToAdd = new Pet(pet.getName(), pet.getSpecies());
		pm.addPet(petToAdd);
		return Response.status(201).entity("success").build();
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCar(Pet pet) {
		Pet petToDelete = pm.getPet(pet.getId());
		pm.deletePet(petToDelete);
		return Response.status(201).entity("success").build();
	}
	
	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pet> getAllPets() {
		return pm.getAllPets();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "REST API /pet is running";
	}
	
	@DELETE
	public Response clearPets(){
		pm.clearPets();
		return Response.status(200).build();
	}
}
