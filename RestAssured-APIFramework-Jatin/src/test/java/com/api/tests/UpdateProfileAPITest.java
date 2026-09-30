package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UserProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileAPITest {

	@Test(description = "Verify update profile is working..")

	public void updateProfile() {

		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234", "uday12345"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());

		System.out.println("-----------------------------------------------------------------------------------");

		UserManagementService userManagementService = new UserManagementService();
		response = userManagementService.getUserProfile(loginResponse.getToken());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "uday1234");
		System.out.println(response.asPrettyString());

		System.out.println("-----------------------------------------------------------------------------------");

		UserProfileRequest userProfileRequest = new UserProfileRequest.Builder().firstName("Har Har")
				.lastName("Mahadev").mobileNumber("9870987654").build();

		response = userManagementService.updateUserProfile(loginResponse.getToken(), userProfileRequest);
		System.out.println(response.asPrettyString());

	}

}
