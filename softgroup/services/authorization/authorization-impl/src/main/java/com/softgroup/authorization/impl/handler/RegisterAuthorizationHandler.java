package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 13:21
 */
@Component
public class RegisterAuthorizationHandler implements AuthorizationRequestHandler {
    @Override
    public String getName() {
        return "registerHandler";
    }

    @Override
    public Response<?> handle(Request<?> msg) {

        return null;
    }
}
