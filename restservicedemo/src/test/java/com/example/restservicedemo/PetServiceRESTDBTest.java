package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.core.MediaType;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.restservicedemo.domain.Pet;
import com.example.restservicedemo.service.PetManager;
import com.jayway.restassured.RestAssured;

public class PetServiceRESTDBTest {
	
	private static IDatabaseConnection connection ;
	private static IDatabaseTester databaseTester;
	
	private static PetManager pm = new PetManager();
	

	@BeforeClass
	public static void setUp() throws Exception{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
		
		Connection jdbcConnection;
		jdbcConnection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		connection = new DatabaseConnection(jdbcConnection);
		
		databaseTester = new JdbcDatabaseTester(
				"org.hsqldb.jdbcDriver", "jdbc:hsqldb:hsql://localhost/workdb", "sa", "");
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(
				new FileInputStream(new File("src/test/resources/fullData.xml")));
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}

	@Test
	public void addPet() throws Exception{
	
		Pet aPet = new Pet("Putin", "Mysz");
		given().contentType(MediaType.APPLICATION_JSON).body(aPet)
				.when().post("/pet/").then().assertThat().statusCode(201);
		
		IDataSet dbDataSet = connection.createDataSet();
		ITable actualTable = dbDataSet.getTable("PET");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
				(actualTable, new String[]{"P_ID"});
		
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
				new File("src/test/resources/petData.xml"));
		ITable expectedTable = expectedDataSet.getTable("PET");
		
		Assertion.assertEquals(expectedTable, filteredTable);
	}
	
	@AfterClass
	public static void tearDown() throws Exception{
		databaseTester.onTearDown();
	}

}
