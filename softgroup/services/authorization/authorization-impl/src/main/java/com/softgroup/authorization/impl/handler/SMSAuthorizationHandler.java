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
import com.softgroup.common.protocol.Status;
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
    private TokenService tokenService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private AuthorizationDetailsCacheService authorizationDetailsCacheService;

    @Override
    public String getName() {
        return "sms_confirm";
    }

    @Override
    public Response<SMSResponse> doHandle(Request<SMSRequest> request) {
        SMSRequest requestData = request.getData();

        String authCode = requestData.getAuthCode();
        String registrationRequestUuid = requestData.getRegistrationRequestUuid();

        if (checkAuthorizationDetails(registrationRequestUuid, authCode)) {
            SMSResponse smsResponse = addToDB(registrationRequestUuid);
            return responseFactory.createResponse(request, smsResponse);
        } else {
            return responseFactory.createResponse(request, Status.NOT_FOUND);

        }
    }

    private boolean checkAuthorizationDetails(String registrationRequestUuid,
                                              String authCode) {
        try {
            AuthorizationDetails details = authorizationDetailsCacheService
                    .getFromCache(registrationRequestUuid);

            String foundRegistrationRequestUuid = details.getRegistrationRequestUuid();
            String foundAuthCode = details.getAuthCode();

            return registrationRequestUuid.equals(foundRegistrationRequestUuid) &&
                    authCode.equals(foundAuthCode);
        } catch (ExecutionException e) {
            return false;
        }
    }


    private SMSResponse addToDB(String key) {
        SMSResponse smsResponse = new SMSResponse();
        try {
            ProfileEntity profileEntity = new ProfileEntity();
            DeviceEntity deviceEntity = new DeviceEntity();

            AuthorizationDetails authorizationDetails =
                    authorizationDetailsCacheService.getFromCache(key);
            Long time = System.currentTimeMillis() / 1000L;


            profileEntity.setName(authorizationDetails.getName());
            profileEntity.setPhoneNumber(authorizationDetails.getPhoneNumber());
            profileEntity.setCreateDateTime(time);
            profileEntity = profileService.save(profileEntity);


            deviceEntity.setLocale_code(authorizationDetails.getLocaleCode());
            deviceEntity.setDeviceId(authorizationDetails.getDeviceId());
            deviceEntity.setUpdateDateTime(time);
            deviceEntity.setProfileId(profileEntity.getId());
            deviceEntity = deviceService.save(deviceEntity);

            smsResponse.setSessionToken(tokenService.
                    generateSessionToken(profileEntity.getId(), deviceEntity.getId()));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return smsResponse;
    }
}

