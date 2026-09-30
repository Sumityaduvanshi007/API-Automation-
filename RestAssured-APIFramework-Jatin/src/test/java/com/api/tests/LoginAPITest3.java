package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;


@Listeners(com.api.Listeners.TestListener.class)
public class LoginAPITest3 {

	@Test(description = "Verify Login API is working1..")

	public void loginTest() {

		LoginRequest loginRequest = new LoginRequest("uday1234", "uday12345");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
	//	System.out.println(response.asPrettyString());
		LoginResponse loginResponse = response.as(LoginResponse.class);

	//	System.out.println(loginResponse.getToken());

		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getId(), 1);
		Assert.assertEquals(loginResponse.getEmail(), "ALOK1234@yahoo.com");
	}

}
