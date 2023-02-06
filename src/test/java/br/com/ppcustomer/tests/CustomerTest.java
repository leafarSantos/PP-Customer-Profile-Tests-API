package br.com.ppcustomer.tests;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.ppcustomer.core.BaseTest;
import br.com.ppcustomer.utils.GenerateToken;

@DisplayName("Classe de testes api pp-customer")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerTest extends BaseTest{

	
	
	@Test
	@Order(1)
	public void shouldReturnError200WhenvalidToken() {
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " + GenerateToken.getToken())
		.when()
		.get("/profile")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
		@Test
		@Order(2)
		public void shouldReturnError401WhenInvalidToken() {
			
	
			given()
			.log().all()
			.header("HTTP_AUTHORIZATION", "Bearer " + "fgdhgcxvx")
			.when()
			.get("/profile")
			.then()
			.statusCode(401)
			.log().all();
			
		}
	
		
		@Test
		@Order(3)
		public void shouldReturnError401WhenTokenDoesNotExist() {
			
			given()
			.log().all()
			.header("HTTP_AUTHORIZATION", "Bearer")
			.when()
			.get("/profile")
			.then()
			.statusCode(401)
			.log().all();
			
		}
		
		
		
		
	
		
	
}
