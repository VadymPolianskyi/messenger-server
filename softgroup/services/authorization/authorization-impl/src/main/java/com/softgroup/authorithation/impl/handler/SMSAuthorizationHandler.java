package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 12:43
 */
public class SMSAuthorizationHandler implements AuthorizationRequestHandler {
    @Override
    public String getName() {
        return "smsHandler";
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return null;
    }
}
