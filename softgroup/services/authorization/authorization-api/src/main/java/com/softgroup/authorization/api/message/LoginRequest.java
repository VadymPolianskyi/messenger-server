package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * @author vadym.polyanski
 * @since 20.02.17.
 */
public class LoginRequest implements RequestData {

	private static final long serialVersionUID = 4895237867750981751L;

	private String sessionToken;

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
}
