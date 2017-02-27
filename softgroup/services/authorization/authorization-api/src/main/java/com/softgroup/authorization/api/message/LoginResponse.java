package com.softgroup.authorization.api.message;

/**
 * @author odin
 * @since 20.02.17.
 */
public class LoginResponse extends AuthorizationResponse {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
