package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileAPITest {
	
	@Test(description = "Verify Get Profile API is working..")
	public void getProfileInfoTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234", "uday12345"));
		LoginResponse loginResponse =  response.as(LoginResponse.class);
		System.out.println( loginResponse.getToken());
	
		
		
		UserManagementService userManagement = new UserManagementService();
		response = userManagement.getUserProfile(loginResponse.getToken());
		UserProfileResponse userResponse = response.as(UserProfileResponse.class);
		
		System.out.println(userResponse.getEmail());
		
	}

}
