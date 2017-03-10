package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.SMSRequest;
import com.softgroup.authorization.api.message.SMSResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
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
        return "sms_confirm";
    }

    @Override
    public Response<SMSResponse> doHandle(Request<SMSRequest> request) {
        SMSRequest requestData = request.getData();

        SMSResponse smsResponse = new SMSResponse();
        smsResponse.setDeviceToken("device4952fe35");
        Response<SMSResponse> response = new Response<SMSResponse>();
        response.setHeader(request.getHeader());
        response.setData(smsResponse);

        ResponseStatus status = new ResponseStatus();
        status.setCode(500);
        status.setMessage("OK");

        response.setStatus(status);
        return response;
    }
}
