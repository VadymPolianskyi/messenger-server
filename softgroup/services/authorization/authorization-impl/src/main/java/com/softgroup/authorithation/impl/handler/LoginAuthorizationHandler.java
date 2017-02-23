package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 13:16
 */
public class LoginAuthorizationHandler <T extends LoginRequest, R extends LoginResponse> extends AbstractRequestHandler<T,R> {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return null;
    }
}
