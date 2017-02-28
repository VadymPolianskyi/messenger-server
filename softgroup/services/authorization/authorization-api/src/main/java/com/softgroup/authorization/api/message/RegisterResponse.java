package com.softgroup.authorization.api.message;

import java.util.Date;

/**
 * @author odin
 * @since 20.02.17.
 */
public class RegisterResponse extends AuthorizationResponse {
	private static final long serialVersionUID = -5146888202653750948L;
	private String registrationRequestUuid;

	public void setRegistrationTimeoutSec(Date registrationTimeoutSec) {
		this.registrationTimeoutSec = registrationTimeoutSec;
	}

	private Date registrationTimeoutSec;
	private String authCode;

	public String getRegistrationRequestUuid() {
		return registrationRequestUuid;
	}

	public void setRegistrationRequestUuid(String registrationRequestUuid) {
		this.registrationRequestUuid = registrationRequestUuid;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
}
