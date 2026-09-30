package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class LoginAPITest2 {
	
	
	@Test(description = "Verify Login API is working1..")
	public void loginTest(){
		
		Response response = given().baseUri("http://64.227.160.186:8080")
		.header("Content-Type", "application/json")
		.body("{ \"username\": \"uday1234\", \"password\": \"uday12345\"}")
		.post("/api/auth/login");
		
		
		System.out.println(response);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
