package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 13:21
 */
public class RegisterAuthorizationHandler <T extends RegisterRequest, R extends RegisterResponse> extends AbstractRequestHandler<T,R> {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Response<?> handle(Request<?> msg) {

        return null;
    }
}
