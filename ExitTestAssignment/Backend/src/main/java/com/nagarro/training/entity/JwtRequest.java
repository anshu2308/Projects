package com.nagarro.training.entity;

public class JwtRequest {
	String userName;
	String password;

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public JwtRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JwtRequest() {
		super();
	}

}
