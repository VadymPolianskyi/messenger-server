package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.Response;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:50
 */
public abstract class AuthorizationResponse extends Response {
    public AuthorizationResponse() {
        getHeader().setType("authorization");
    }
}
