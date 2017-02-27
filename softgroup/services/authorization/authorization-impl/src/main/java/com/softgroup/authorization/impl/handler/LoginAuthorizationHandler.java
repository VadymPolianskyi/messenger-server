package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 13:16
 */@Component
public class LoginAuthorizationHandler extends AbstractRequestHandler<LoginRequest, LoginResponse > implements AuthorizationRequestHandler {
    @Override
    public String getName() {
        return "loginHandler";
    }

    @Override
    public Response<LoginResponse> doHandle(Request<LoginRequest> request) {
        return null;
    }
}
