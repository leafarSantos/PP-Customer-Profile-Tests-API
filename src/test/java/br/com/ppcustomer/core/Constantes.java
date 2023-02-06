package br.com.ppcustomer.core;

import io.restassured.http.ContentType;

public interface Constantes {

	String APP_BASE_URL = "https://api-dev.pedepronto.com.br";
	String APP_BASE_PATH = "/v1/customer";	
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	Long MAX_TIMEOUT = 30000L;
}
