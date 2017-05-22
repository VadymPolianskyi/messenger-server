package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.impl.service.DeviceService;
import com.softgroup.common.jwt.impl.service.TokenService;
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
 * Time: 13:16
 */
@Component
public class LoginAuthorizationHandler extends
            AbstractRequestHandler<LoginRequest, LoginResponse >
                                implements AuthorizationRequestHandler {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private DeviceService deviceService;

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public Response<LoginResponse> doHandle(Request<LoginRequest> request) {
        LoginRequest requestData = request.getData();
        LoginResponse loginResponse = new LoginResponse();

        String sessionToken = requestData.getSessionToken();

        if (sessionToken == null) {
            return responseFactory.createResponse(request, Status.BAD_REQUEST);
        }

        String profileID = tokenService.getProfileID(sessionToken);
        String deviceID = tokenService.getDeviceID(sessionToken);

        String deviceToken = tokenService.generateDeviceToken(profileID, deviceID);
        Long tokenCreationTime = tokenService.getTimeOfCreation(deviceToken);

        DeviceEntity deviceEntity = deviceService.findDeviceEntityById(tokenService.getDeviceID(deviceToken));
        deviceEntity.setUpdateDateTime(tokenCreationTime);
        deviceService.update(deviceEntity);

        loginResponse.setToken(deviceToken);

        return responseFactory.createResponse(request, loginResponse);


    }
}
