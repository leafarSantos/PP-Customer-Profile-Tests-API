package br.com.ppcustomer.utils;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.AfterAll;

import br.com.ppcustomer.entities.Customer;
import io.restassured.http.ContentType;

public class GenerateToken{

	private final static String email = "VARRONCHE.TAKING@PEDEPRONTO.COM.BR";
	private final static String password = "123456";
	private final static String FIREBASE_KEY = "AIzaSyDbrvdvZG7e-Ii43jsN8g_EO8z5EQdR2Wc";
	


	public static String getToken() {
		
		Customer customer = new Customer();
		
		customer.setReturnSecureToken(true);
		customer.setEmail(email);
		customer.setPassword(password);
		
		String token =
    			
	    	given()
	    	.contentType(ContentType.JSON)
	    	.urlEncodingEnabled(false)
	    	.queryParam("key", FIREBASE_KEY)
			.when()
	
			.body(customer)
			.post("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword")
			
			.then()
			.statusCode(200)
			.extract().path("idToken");
	    	return token;
		}
	
	public static void main(String[] args) {
		System.out.println(getToken());
	}
	
}
