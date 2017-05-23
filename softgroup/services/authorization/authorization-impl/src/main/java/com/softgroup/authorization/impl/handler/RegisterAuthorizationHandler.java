package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.impl.handler.key.KeysGenerator;
import com.softgroup.common.cache.entity.AuthorizationDetails;
import com.softgroup.common.cache.service.AuthorizationDetailsCacheService;
import com.softgroup.common.dao.impl.service.ProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 13:21
 */
@Component
public class RegisterAuthorizationHandler extends AbstractRequestHandler<RegisterRequest, RegisterResponse> implements AuthorizationRequestHandler {

    @Autowired
    private KeysGenerator keysGenerator;

    @Autowired
    private AuthorizationDetailsCacheService authorizationDetailsCacheService;

    @Override
    public String getName() {
        return "register";
    }


    @Override
    public Response<RegisterResponse> doHandle(Request<RegisterRequest> request) {
        RegisterRequest requestData = request.getData();
        RegisterResponse registerResponse = new RegisterResponse();

        String phoneNumber = requestData.getPhoneNumber();
        String localeCode = requestData.getLocaleCode();
        String deviceId = requestData.getDeviceId();
        String name = requestData.getName();

        if (phoneNumber == null && localeCode == null && deviceId == null && name ==null) {
            return responseFactory.createResponse(request, Status.BAD_REQUEST);
        }

        String registrationRequestUuid = keysGenerator.generateKey();
        String authCode = keysGenerator.generateKey();

        authorizationDetailsCacheService.put(
                new AuthorizationDetails(registrationRequestUuid,
                        authCode, phoneNumber, localeCode, deviceId, name));

        registerResponse.setRegistrationRequestUuid(registrationRequestUuid);
        registerResponse.setAuthCode(authCode);
        registerResponse.setRegistrationTimeoutSec(10);

        return responseFactory.createResponse(request, registerResponse);
    }
}
