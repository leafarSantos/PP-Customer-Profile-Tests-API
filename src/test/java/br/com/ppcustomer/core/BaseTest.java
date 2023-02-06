package br.com.ppcustomer.core;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

public class BaseTest implements Constantes {

	@BeforeAll
	public static void setup() {
		
	 baseURI = APP_BASE_URL;
	 //port = APP_PORT;
	 basePath = APP_BASE_PATH;
	 
	 RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
	 reqBuilder.setContentType(APP_CONTENT_TYPE);
	 requestSpecification = reqBuilder.build();
	 
	 ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
	 resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
	 responseSpecification = resBuilder.build();
	 
	 //habilita o log quando há problema no teste
	 enableLoggingOfRequestAndResponseIfValidationFails();
	 	
	}

	
}
