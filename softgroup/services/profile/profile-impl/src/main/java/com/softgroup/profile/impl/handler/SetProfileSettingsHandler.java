package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.dao.impl.service.ProfileSettingsService;
import com.softgroup.common.jwt.impl.service.TokenService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.SetProfileSettingsRequest;
import com.softgroup.profile.api.message.SetProfileSettingsResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:48
 */
@Component
public class SetProfileSettingsHandler
        extends AbstractRequestHandler<SetProfileSettingsRequest,
                SetProfileSettingsResponse> implements ProfileRequestHandler {
    @Autowired
    TokenService tokenService;

    @Autowired
    ProfileSettingsService profileSettingsService;

    public String getName() {
        return "set_profile_settings";
    }

    @Override
    public Response<SetProfileSettingsResponse> doHandle(Request<SetProfileSettingsRequest> request) {
        SetProfileSettingsRequest requestData = request.getData();
        SetProfileSettingsResponse setProfileSettingsResponse = new SetProfileSettingsResponse();

        String profileId = request.getRoutingData().getProfileId();
        ProfileSettingsEntity settingsEntity = requestData.getProfileSettingsEntity();
        settingsEntity.setProfileId(profileId);
        Response<SetProfileSettingsResponse> response = new Response<SetProfileSettingsResponse>();
        response.setHeader(request.getHeader());
        response.setData(setProfileSettingsResponse);
        ResponseStatus status = new ResponseStatus();

        try {
            profileSettingsService.insert(settingsEntity);
            status.setCode(200);
            status.setMessage("OK");
        } catch (Exception e) {
            status.setCode(500);
            status.setMessage("ERROR");
        }
        response.setStatus(status);
        return response;
    }
}
