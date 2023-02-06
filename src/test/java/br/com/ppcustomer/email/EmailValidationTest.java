package br.com.ppcustomer.email;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import br.com.ppcustomer.entities.Email;
import io.restassured.http.ContentType;

public class EmailValidationTest{

	private String email = "leafarccomputacao@gmail.com";
	Email mail = new Email();

	@Test
	@Order(1)
	public void shouldReturn200WhensendEmailVerificateCode() {
		
		mail.setEmail(email);
		
		given()
		.log().all()
		   .contentType(ContentType.JSON)
		.when()
		
		.body(mail)
		.post("https://api-dev.pedepronto.com.br/v1/mail/send")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
}
