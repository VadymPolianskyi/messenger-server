package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.SMSRequest;
import com.softgroup.authorization.api.message.SMSResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.cache.entity.AuthorizationDetails;
import com.softgroup.common.cache.service.AuthorizationDetailsCacheService;
import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.service.DeviceService;
import com.softgroup.common.dao.impl.service.ProfileService;
import com.softgroup.common.jwt.impl.service.TokenService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 12:43
 */
@Component
public class SMSAuthorizationHandler extends
        AbstractRequestHandler<SMSRequest, SMSResponse> implements
                                            AuthorizationRequestHandler {

    @Autowired
    TokenService tokenService;

    @Autowired
    ProfileService profileService;

    @Autowired
    DeviceService deviceService;

    @Autowired
    AuthorizationDetailsCacheService authorizationDetailsCacheService;

    @Override
    public String getName() {
        return "sms_confirm";
    }

    @Override
    public Response<SMSResponse> doHandle(Request<SMSRequest> request) {
        SMSRequest requestData = request.getData();

        String authCode = requestData.getAuthCode();
        String registrationRequestUuid = requestData.getRegistrationRequestUuid();

        SMSResponse smsResponse = new SMSResponse();
        ResponseStatus status = new ResponseStatus();
        if (checkAuthorizationDetails(registrationRequestUuid, authCode)) {

            smsResponse = addToDB(registrationRequestUuid);
            status.setCode(200);
            status.setMessage("OK");
        } else {
            status.setCode(404);
            status.setMessage("Not Found");

        }

        Response<SMSResponse> response = new Response<SMSResponse>();
        response.setHeader(request.getHeader());
        response.setData(smsResponse);
        response.setStatus(status);
        return response;
    }

    private boolean checkAuthorizationDetails(String registrationRequestUuid,
                                              String authCode) {
        try {
            AuthorizationDetails details = authorizationDetailsCacheService
                    .getFromCache(registrationRequestUuid);

            String regReqUuid = details.getRegistrationRequestUuid();
            String authC = details.getAuthCode();

            return registrationRequestUuid.equals(regReqUuid) && authCode.equals(authC);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }


    private SMSResponse addToDB(String key) {
        SMSResponse smsResponse = new SMSResponse();
        ProfileEntity profileEntity;
        DeviceEntity deviceEntity;
        try {
            profileEntity = new ProfileEntity();
            deviceEntity = new DeviceEntity();

            AuthorizationDetails authorizationDetails =
                    authorizationDetailsCacheService.getFromCache(key);
            profileEntity.setCreateDateTime(System.currentTimeMillis() / 1000L);
            profileEntity.setPhoneNumber(authorizationDetails.getPhoneNumber());
            profileEntity = profileService.insertProfile(profileEntity);


            deviceEntity.setLocale_code(authorizationDetails.getLocaleCode());
            deviceEntity.setDeviceId(authorizationDetails.getDeviceId());
            deviceEntity.setProfileEntity(profileEntity);
            deviceService.insertDevice(deviceEntity);
            smsResponse.setDeviceToken(tokenService.
                    generateDeviceToken(profileEntity.getId(), deviceEntity.getId()));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return smsResponse;
    }
}
