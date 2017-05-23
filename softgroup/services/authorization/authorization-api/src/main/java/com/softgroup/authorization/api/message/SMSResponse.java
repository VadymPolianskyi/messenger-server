package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 12:22
 */
public class SMSResponse implements ResponseData {

    private static final long serialVersionUID = -6713161050836121166L;

    private String sessionToken;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
