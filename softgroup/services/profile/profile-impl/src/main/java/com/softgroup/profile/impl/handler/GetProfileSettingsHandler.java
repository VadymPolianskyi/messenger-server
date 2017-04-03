package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.dao.impl.service.ProfileSettingsService;
import com.softgroup.common.jwt.impl.service.TokenService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetProfileSettingsRequest;
import com.softgroup.profile.api.message.GetProfileSettingsResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:47
 */
@Component
public class GetProfileSettingsHandler
        extends AbstractRequestHandler<GetProfileSettingsRequest,
            GetProfileSettingsResponse> implements ProfileRequestHandler {

    @Autowired
    TokenService tokenService;

    @Autowired
    ProfileSettingsService profileSettingsService;

    public String getName() {
        return "get_profile_settings";
    }

    @Override
    public Response<GetProfileSettingsResponse> doHandle(Request<GetProfileSettingsRequest> request) {
        GetProfileSettingsRequest requestData = request.getData();
        GetProfileSettingsResponse getProfileSettingsResponse = new GetProfileSettingsResponse();

        String profileId = request.getRoutingData().getProfileId();
        ProfileSettingsEntity settingsEntity = profileSettingsService.findByProfileId(profileId);
        getProfileSettingsResponse.setSettings(settingsEntity);

        Response<GetProfileSettingsResponse> response = new Response<GetProfileSettingsResponse>();
        response.setHeader(request.getHeader());
        response.setData(getProfileSettingsResponse);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");
        response.setStatus(status);
        return response;
    }
}
