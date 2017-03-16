package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.dao.impl.service.ProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 13:21
 */
@Component
public class RegisterAuthorizationHandler extends AbstractRequestHandler<RegisterRequest, RegisterResponse> implements AuthorizationRequestHandler {

    @Autowired
    ProfileService profileService;

    @Override
    public String getName() {
        return "register";
    }


    @Override
    public Response<RegisterResponse> doHandle(Request<RegisterRequest> request) {

        RegisterRequest requestData = request.getData();
        RegisterResponse registerResponse = new RegisterResponse();
        String authCode = UUID.randomUUID().toString();
        registerResponse.setAuthCode(authCode + ", tvar");
        registerResponse.setRegistrationRequestUuid("id39563945834");
        registerResponse.setRegistrationTimeoutSec("11");

        Response<RegisterResponse> response = new Response<RegisterResponse>();
        response.setHeader(request.getHeader());
        response.setData(registerResponse);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");

        response.setStatus(status);

        return response;
    }
}
