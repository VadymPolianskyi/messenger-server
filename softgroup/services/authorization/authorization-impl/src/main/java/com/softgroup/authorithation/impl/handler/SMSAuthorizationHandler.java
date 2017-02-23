package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.SMSRequest;
import com.softgroup.authorization.api.message.SMSResponse;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 12:43
 */
public class SMSAuthorizationHandler<T extends SMSRequest, R extends SMSResponse> extends AbstractRequestHandler<T,R> {
       @Override
    public String getName() {
        return null;
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return null;
    }
}
