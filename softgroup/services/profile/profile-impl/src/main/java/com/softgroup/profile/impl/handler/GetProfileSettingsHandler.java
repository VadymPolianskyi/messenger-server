package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.dao.impl.service.ProfileSettingsService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.model.maper.Mapper;
import com.softgroup.profile.api.dto.ProfileSettingsDTO;
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
    private ProfileSettingsService profileSettingsService;

    @Autowired
    private Mapper<ProfileSettingsEntity, ProfileSettingsDTO> mapper;

    public String getName() {
        return "get_profile_settings";
    }

    @Override
    public Response<GetProfileSettingsResponse> doHandle(Request<GetProfileSettingsRequest> request) {
        GetProfileSettingsRequest requestData = request.getData();
        GetProfileSettingsResponse getProfileSettingsResponse = new GetProfileSettingsResponse();
        String profileId = request.getRoutingData().getProfileId();

        ProfileSettingsEntity settingsEntity = profileSettingsService.findByProfileId(profileId);

        ResponseStatus status = new ResponseStatus();
        if (settingsEntity == null) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        } else {
            getProfileSettingsResponse.setProfileSettings(mapper.map(settingsEntity, ProfileSettingsDTO.class));
            return responseFactory.createResponse(request, getProfileSettingsResponse);
        }
    }
}
