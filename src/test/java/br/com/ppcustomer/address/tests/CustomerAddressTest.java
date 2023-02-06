package br.com.ppcustomer.address.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.ppcustomer.core.BaseTest;
import br.com.ppcustomer.entities.CustomerAddress;
import br.com.ppcustomer.utils.GenerateToken;
import br.com.ppcustomer.utils.PlayloadUtils;

@DisplayName("Classe de testes api pp-customer-Address")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerAddressTest extends BaseTest{

	private static String country = "BR";
	private static String state = "Santa Cataria";
	private static String city = "Blumenal";
	private static String district = "Taipas";
	private static String street = "Rua 10";
	private static String number = "556";
	private static String postalCode = "02987-090";
	private static String complement = "Casa 2";
	private static String reference = "Próximo ao Posto de saúde";
	private static String formattedAddress = "String";
	private static String type = "HOME";
	private static String typeName = "String";
	private static boolean principal = false;
	private static boolean enabled = false;

	
	CustomerAddress customerAddress =  new CustomerAddress();
	
	
	
	@Test
	@Tag("valid")
	@Order(1)
	public void shouldReturnError401WhenInvalidTokenOnCreate() {
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " + "fgdhgcxvx")
		.when()
		.body("{}")
		.post("/address")
		.then()
		.statusCode(401)
		.log().all();
	}

	@Test
	@Tag("valid")
	@Order(2)
	public void shouldReturnError401WhenTokenDoesNotExistOnCreate() {

		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer")
		.when()
		.body("{}")
		.post("/address")
		.then()
		.statusCode(401)
		.log().all();
		
	}
	
	
	
	@Test
	@Tag("valid")
	@Order(3)
	public void shouldReturnError400WhenVoidBody() {
			
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " +  GenerateToken.getToken())
		.when()
		.body("")
		.post("/address")
		.then()
		.statusCode(400)
		.log().all();
	}
	
	
	@Test
	@Tag("invalid")
	@Order(4)
	public void shouldReturnError400WhenVoidBodyWithKeys() {
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " +  GenerateToken.getToken())
		.when()
		.body("{}")
		.post("/address")
		.then()
		.statusCode(400)
		.log().all();
	}
	
	
	@Test
	@Tag("invalid")
	@Order(5)
	public void shouldReturnError400WhenCountryNotInformed() {
	
		customerAddress.setState(state);
		customerAddress.setCity(city);
		customerAddress.setDistrict(district);
		customerAddress.setStreet(street);
		customerAddress.setNumber(number);
		customerAddress.setPostalCode(postalCode);
		customerAddress.setComplement(complement);
		customerAddress.setReference(reference);
		customerAddress.setFormattedAddress(formattedAddress);
		customerAddress.setType(type);
		customerAddress.setTypeName(typeName);
		
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " +  GenerateToken.getToken())
		.when()
		.body(customerAddress)
		.post("/address")
		.then()
		.statusCode(400)
		.log().all();
	}
	
	

	@Test
	@Tag("invalid")
	@Order(6)
	public void shouldReturnError400WhenStateNotInformed() {
		
			customerAddress.setCountry(country);
			customerAddress.setCity(city);
			customerAddress.setDistrict(district);
			customerAddress.setStreet(street);
			customerAddress.setNumber(number);
			customerAddress.setPostalCode(postalCode);
			customerAddress.setComplement(complement);
			customerAddress.setReference(reference);
			customerAddress.setFormattedAddress(formattedAddress);
			customerAddress.setType(type);
			customerAddress.setTypeName(typeName);
			
			
			given()
			.log().all()
			.header("HTTP_AUTHORIZATION", "Bearer " +  GenerateToken.getToken())
			.when()
			.body(customerAddress)
			.post("/address")
			.then()
			.statusCode(400)
			.log().all();
		}

	
	@Test
	@Tag("invalid")
	@Order(7)
	public void shouldReturnError400WhenCityNotInformed() {
	
			customerAddress.setCountry(country);
			customerAddress.setState(state);
			customerAddress.setDistrict(district);
			customerAddress.setStreet(street);
			customerAddress.setNumber(number);
			customerAddress.setPostalCode(postalCode);
			customerAddress.setComplement(complement);
			customerAddress.setReference(reference);
			customerAddress.setFormattedAddress(formattedAddress);
			customerAddress.setType(type);
			customerAddress.setTypeName(typeName);
			
			
			given()
			.log().all()
			.header("HTTP_AUTHORIZATION", "Bearer " +  GenerateToken.getToken())
			.when()
			.body(customerAddress)
			.post("/address")
			.then()
			.statusCode(400)
			.log().all();
		}
	
	
	@Test
	@Tag("invalid")
	@Order(8)
	public void shouldReturnError400WhenDistrictNotInformed() {
		
			customerAddress.setCountry(country);
			customerAddress.setState(state);
			customerAddress.setCity(city);
			customerAddress.setStreet(street);
			customerAddress.setNumber(number);
			customerAddress.setPostalCode(postalCode);
			customerAddress.setComplement(complement);
			customerAddress.setReference(reference);
			customerAddress.setFormattedAddress(formattedAddress);
			customerAddress.setType(type);
			customerAddress.setTypeName(typeName);
			
			
			given()
			.log().all()
			.header("HTTP_AUTHORIZATION", "Bearer " +  GenerateToken.getToken())
			.when()
			.body(customerAddress)
			.post("/address")
			.then()
			.statusCode(400)
			.log().all();
		}
	
	
	@Test
	@Tag("invalid")
	@Order(9)
	public void shouldReturnError400WhenStreetNotInformed() {
		
			customerAddress.setCountry(country);
			customerAddress.setState(state);
			customerAddress.setCity(city);
			customerAddress.setDistrict(district);
			customerAddress.setNumber(number);
			customerAddress.setPostalCode(postalCode);
			customerAddress.setComplement(complement);
			customerAddress.setReference(reference);
			customerAddress.setFormattedAddress(formattedAddress);
			customerAddress.setType(type);
			customerAddress.setTypeName(typeName);
			
			given()
			.log().all()
			.header("HTTP_AUTHORIZATION", "Bearer " +  GenerateToken.getToken())
			.when()
			.body(customerAddress)
			.post("/address")
			.then()
			.statusCode(400)
			.log().all();
		}

	@Test
	@Tag("invalid")
	@Order(10)
	public void shouldReturnError400WhenPostalCodeNotInformed() {
		
		
		
		customerAddress.setCountry(country);
		customerAddress.setState(state);
		customerAddress.setCity(city);
		customerAddress.setDistrict(district);
		customerAddress.setStreet(street);
		customerAddress.setNumber(number);
		customerAddress.setComplement(complement);
		customerAddress.setReference(reference);
		customerAddress.setFormattedAddress(formattedAddress);
		customerAddress.setType(type);
		customerAddress.setTypeName(typeName);
			
			
			given()
			.log().all()
			.header("HTTP_AUTHORIZATION", "Bearer " +  GenerateToken.getToken())
			.when()
			.body(customerAddress)
			.post("/address")
			.then()
			.statusCode(400)
			.log().all();
		}
	
	
	@Test
	@Tag("valid")
	@Order(11)
	public void shouldReturnError401WhenInvalidTokenOnGet() {
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " + "fgdhgcxvx")
		.when()
		.get("/address")
		.then()
		.statusCode(401)
		.log().all();
	}

	@Test
	@Tag("valid")
	@Order(12)
	public void shouldReturnError401WhenTokenDoesNotExistOnGet() {

		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer")
		.when()
		.get("/address")
		.then()
		.statusCode(401)
		.log().all();
		
	}
	
	@Test
	@Tag("valid")
	@Order(13)
	public void shouldReturn200WhenTokenExistAndValidateFields(){
		
		int posicaoID = PlayloadUtils.sizeList()-1;
		
		given()
		.header("HTTP_AUTHORIZATION", "Bearer " + GenerateToken.getToken())
		.when()
		.get("/address")
		.then()
		.statusCode(200)
		.body("id["+posicaoID+"]", Matchers.is(notNullValue()))
		.body("customerId["+posicaoID+"]", Matchers.is(notNullValue()))
		.body("country["+posicaoID+"]", is(country))
		.body("state["+posicaoID+"]", is(state))
		.body("city["+posicaoID+"]", is(city))
		.body("district["+posicaoID+"]", is(district))
		.body("street["+posicaoID+"]", is(street))
		.body("number["+posicaoID+"]", is(number))
		.body("complement["+posicaoID+"]", is(complement))
		.body("reference["+posicaoID+"]", is(reference))
		.body("formattedAddress["+posicaoID+"]", is(formattedAddress))
		.body("type["+posicaoID+"]", is(type))
		.body("typeName["+posicaoID+"]", is(typeName))
		.body("principal["+posicaoID+"]", is(principal))
		.body("enabled["+posicaoID+"]", is(enabled))
		;
	
	}
	
	@Test
	@Tag("invalid")
	@Order(14)
	public void ShouldReturnError400WhenTryingToCreateASecondHOMETypeAddress() {
	
		type = "WORK";
		customerAddress.setState(state);
		customerAddress.setCountry(country);
		customerAddress.setCity(city);
		customerAddress.setDistrict(district);
		customerAddress.setStreet(street);
		customerAddress.setNumber(number);
		customerAddress.setPostalCode(postalCode);
		customerAddress.setComplement(complement);
		customerAddress.setReference(reference);
		customerAddress.setFormattedAddress(formattedAddress);
		customerAddress.setType(type);
		customerAddress.setTypeName(typeName);
		
		given()
		.log().all()
		.header("HTTP_AUTHORIZATION", "Bearer " +  GenerateToken.getToken())
		.when()
		.body(customerAddress)
		.post("/address")
		.then()
		.statusCode(400)
		.log().all();
	}

}
