package com.softgroup.authorization.api.message;

/**
 * @author odin
 * @since 20.02.17.
 */
public class LoginRequest extends AuthorizationRequest{

	private static final long serialVersionUID = 4895237867750981751L;

	private String deviceToken;

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
}
