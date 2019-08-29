package com.qa.tests;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFromString {
	
	@Test
	public void readstring() throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper mapper = new ObjectMapper();
		
	    String CarJson = "{ \"brand\" : \"Mercedes\", \"door\" : 5 }";
		
		Car car = mapper.readValue(CarJson,Car.class);
		
		System.out.println(car.getBrand()+"-----"+ car.getDoor());
		
		
	}
	
	@Test
	public void readJsonFile() throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper mapper = new ObjectMapper();
		
	    File f = new File("C:\\Users\\Sindhusha_Pericharla\\eclipse-workspace\\restapi\\src\\test\\java\\com\\qa\\tests\\CarDetails.json");
		
		Car car = mapper.readValue(f,Car.class);
		
		System.out.println(car.getBrand()+"-----"+ car.getDoor());
		
		
	}
	
	@Test
	public void writestring() throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper mapper = new ObjectMapper();
		
		Car c = new Car(6,"Innova");
		
		 mapper.writeValue(new File("C:\\Users\\Sindhusha_Pericharla\\eclipse-workspace\\restapi\\src\\test\\java\\com\\qa\\tests\\CarJson.json"), c);
		
	}
	
	
	

}
