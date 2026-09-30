package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class LoginAPITest {
	
	@Test(description = "Verify Login API is working....")
	public void loginTest(){
		
		RestAssured.baseURI = "http://64.227.160.186:8080";
		
		Response response = RestAssured.given()
		.header("Content-Type", "application/json")
		.body("{ \"username\": \"uday1234\", \"password\": \"uday12345\"}")
		.post("/api/auth/login");
		
		
		System.out.println(response);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
