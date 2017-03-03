package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.SMSRequest;
import com.softgroup.authorization.api.message.SMSResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 12:43
 */
@Component
public class SMSAuthorizationHandler extends AbstractRequestHandler<SMSRequest, SMSResponse> implements AuthorizationRequestHandler {
    @Override
    public String getName() {
        return "sms";
    }

    @Override
    public Response<SMSResponse> doHandle(Request<SMSRequest> request) {
        return null;
    }
}
