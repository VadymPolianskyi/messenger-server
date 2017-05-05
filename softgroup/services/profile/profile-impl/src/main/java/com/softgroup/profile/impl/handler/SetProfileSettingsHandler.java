package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.dao.impl.service.ProfileSettingsService;
import com.softgroup.common.jwt.impl.service.TokenService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.model.maper.Mapper;
import com.softgroup.profile.api.dto.ProfileDTO;
import com.softgroup.profile.api.dto.ProfileSettingsDTO;
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
    private ProfileSettingsService profileSettingsService;

    @Autowired
    private Mapper<ProfileSettingsEntity, ProfileSettingsDTO> mapper;

    public String getName() {
        return "set_profile_settings";
    }

    @Override
    public Response<SetProfileSettingsResponse> doHandle(Request<SetProfileSettingsRequest> request) {
        SetProfileSettingsRequest requestData = request.getData();
        SetProfileSettingsResponse setProfileSettingsResponse = new SetProfileSettingsResponse();

        String profileId = request.getRoutingData().getProfileId();
        ProfileSettingsDTO profileSettingsDTO = requestData.getProfileSettings();
        profileSettingsDTO.setProfileId(profileId);

        try {
            profileSettingsService.save(mapper.mapRevert(profileSettingsDTO, ProfileSettingsEntity.class));
            return responseFactory.createResponse(request, setProfileSettingsResponse);
        } catch (Exception e) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        }
    }
}
