package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgetPasswordAPITest {
	
	
	@Test(description = "Verify forget password API is working..")
	public void forgetPassword() {
		AuthService auth = new AuthService();
		Response response = auth.forgetPassword("example@gmail.com");
		System.out.println(response.asPrettyString());
	}

}
