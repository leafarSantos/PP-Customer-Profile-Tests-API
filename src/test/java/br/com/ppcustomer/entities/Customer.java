package br.com.ppcustomer.entities;

public class Customer {

	private boolean returnSecureToken;
	private String email;
	private String password;
	
	
	public boolean isReturnSecureToken() {
		return returnSecureToken;
	}
	public void setReturnSecureToken(boolean returnSecureToken) {
		this.returnSecureToken = returnSecureToken;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
