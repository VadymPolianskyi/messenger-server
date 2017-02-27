package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.Request;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:50
 */
public abstract class AuthorizationRequest extends Request {
    public AuthorizationRequest() {
        getHeader().setType("authorization");
    }
}
