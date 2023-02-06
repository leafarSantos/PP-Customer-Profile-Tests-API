package br.com.ppcustomer.utils;

import static io.restassured.RestAssured.given;

import java.util.List;

import br.com.ppcustomer.core.BaseTest;

public class PlayloadUtils extends BaseTest {


	public static int sizeList() {		
		List <String> id =  
		given()
		.header("HTTP_AUTHORIZATION", "Bearer " + GenerateToken.getToken())
		.when()
		.get("/address")
		.then()
		.statusCode(200)
		.log().all()
		.extract().path("idToken");
		return id.size();
	}
	
	public static void main(String[] args) {
		System.out.println(sizeList());
	}
}
