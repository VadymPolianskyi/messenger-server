package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 13:16
 */
@Component
public class LoginAuthorizationHandler extends
            AbstractRequestHandler<LoginRequest, LoginResponse >
                                implements AuthorizationRequestHandler {
    @Override
    public String getName() {
        return "login";
    }

    @Override
    public Response<LoginResponse> doHandle(Request<LoginRequest> request) {
        LoginRequest requestData = request.getData();
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(requestData.getDeviceToken());

        Response<LoginResponse> response = new Response<LoginResponse>();
        response.setHeader(request.getHeader());
        response.setData(loginResponse);

        ResponseStatus status = new ResponseStatus();
        status.setCode(700);
        status.setMessage("OK");

        response.setStatus(status);
        return response;
    }
}
