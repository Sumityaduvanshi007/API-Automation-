package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationAPITest {
	
	@Test(description = "Verify Account creation is working1..")

	public void signTest() {
		SignUpRequest signUpRequest= new SignUpRequest.Builder()
				.firstName("Vinay")
				.lastName("Test")
				.email("vinay122@gmail.com")
				.mobileNumber("9876789870")
				.password("vinay122@")
				.build();
		AuthService authService = new AuthService();
		Response signUpresponse= authService.signUp(signUpRequest);
		
		System.out.println(signUpresponse.asPrettyString());
	}
	
	

}
