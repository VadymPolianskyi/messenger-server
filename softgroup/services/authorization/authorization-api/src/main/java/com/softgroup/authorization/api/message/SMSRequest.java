package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 12:22
 */
public class SMSRequest implements RequestData {

    private String authCode;
    private String registrationRequestUuid;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getRegistrationRequestUuid() {
        return registrationRequestUuid;
    }

    public void setRegistrationRequestUuid(String registrationRequestUuid) {
        this.registrationRequestUuid = registrationRequestUuid;
    }
}
