package com.RestAPI_Base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
//I am going to create common methods which we use.
	public static Response GetRequest(String requestUri) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestUri);
		return response;
	}

	public static Response GetRequest(String requestUri, String bearer_token) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearer_token);

		Response response = requestSpecification.get(requestUri);
		return response;
	}

	public static Response PostRequest(String requestUri, String requestpayLoad) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestUri);
		return response;
	}

	public static Response PostRequest(String requestUri, String requestpayLoad, String bearer_token) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearer_token);
		Response response = requestSpecification.post(requestUri);
		return response;
	}

	public static Response PutRequest(String requestUri, String requestpayLoad, String bearer_token) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearer_token);
		Response response = requestSpecification.put(requestUri);
		return response;
	}

	public static Response PatchRequest(String requestUri, String requestpayLoad, String bearer_token) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearer_token);
		Response response = requestSpecification.patch(requestUri);
		return response;
	}

	public static Response DeleteRequestWithout_Payload(String requestUri, String bearer_token) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearer_token);
		Response response = requestSpecification.delete(requestUri);
		return response;
	}

	public static Response DeleteRequestWithPayload(String requestUri, String requestpayLoad, String bearer_token) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
		requestSpecification.contentType(ContentType.JSON);

		requestSpecification.header("Authorization", "Bearer " + bearer_token);
		Response response = requestSpecification.delete(requestUri);
		return response;
	}
}
