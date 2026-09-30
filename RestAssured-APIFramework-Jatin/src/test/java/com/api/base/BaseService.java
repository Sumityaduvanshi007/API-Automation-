package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	// - Wrapper for Rest Assured !!!

	// CReating request
	// Handling response
	// Base URI

	private static final String BASE_URL = "http://64.227.160.186:8080";

	private RequestSpecification requestSpec;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}

	// Created constructor for initialize for instance variable
	public BaseService() {
		requestSpec = given().baseUri(BASE_URL);

	}

	protected Response postRequest(Object payload, String endPoint) {
		return requestSpec.contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	
	protected Response putRequest(Object payload, String endPoint) {
		return requestSpec.contentType(ContentType.JSON).body(payload).put(endPoint);
		
	}

	protected Response getRequest(String endPoint) {
		return requestSpec.get(endPoint);
	}
	
	protected void setAuthToken(String token) {
		requestSpec.header("Authorization", "Bearer "+token);
	}

}
