package br.com.ppcustomer.terms;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.ppcustomer.core.BaseTest;
import br.com.ppcustomer.utils.GenerateToken;

@DisplayName("Classe de testes Termos de Uso")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TermsOfUseTest extends BaseTest {
	
	
	private static boolean current = true;
	private static String key = "terms01";
	
	@Test
	@Order(1)
	public void shouldReturnError401WhenvalidToken() {
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " + "erwetyui")
		.when()
		.get("termsOfUse/terms01")
		.then()
		.statusCode(401)
		.log().all();
		
	}
	
	@Test
	@Order(2)
	public void shouldReturnError401NotInformedToken() {
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer ")
		.when()
		.get("termsOfUse/terms01")
		.then()
		.statusCode(401)
		.log().all();
		
	}
	

	@Test
	@Tag("valid")
	@Order(3)
	public void shouldReturn200WhenValidTokenAndValidadeteFields() {
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " +GenerateToken.getToken())
		.when()
		.get("termsOfUse/terms01")
		.then()
		.statusCode(200)
		.body("key", is(key))
		.body("content", is(notNullValue()))
		.body("createdAt", is(notNullValue()))
		.body("current", is(current))
		.log().all();
	}


	@Test
	@Tag("valid")
	@Order(4)
	public void shoulReturnError401WhenInvalidTokenOnPost() {
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " + "ewert")
		.when()
		.get("termsOfUse/terms01/accept")
		.then()
		.statusCode(401)
		.log().all();
	}

	@Test
	@Tag("valid")
	@Order(5)
	public void shouldReturnError401NotInformedTokenOnPost() {
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer ")
		.when()
		.get("termsOfUse/terms01/accept")
		.then()
		.statusCode(401)
		.log().all();
	}
	
	@Test
	@Tag("valid")
	@Order(6)
	public void shoulAccpetTermsAndReturn200WhenValidTokenAndValidadeteFields() {
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " + GenerateToken.getToken())
		.when()
		.post("termsOfUse/terms01/accept")
		.then()
		.statusCode(200)
		.body("key", is(key))
		.body("content", is(notNullValue()))
		.body("createdAt", is(notNullValue()))
		.body("current", is(current))
		.log().all();
	}

	
}
