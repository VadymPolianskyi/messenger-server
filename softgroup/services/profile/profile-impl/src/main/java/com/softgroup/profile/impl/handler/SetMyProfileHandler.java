package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.service.ProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.model.maper.Mapper;
import com.softgroup.profile.api.dto.ProfileDTO;
import com.softgroup.profile.api.message.SetMyProfileRequest;
import com.softgroup.profile.api.message.SetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:45
 */
@Component
public class SetMyProfileHandler
        extends AbstractRequestHandler<SetMyProfileRequest,
                SetMyProfileResponse> implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private Mapper<ProfileEntity, ProfileDTO> mapper;

    public String getName() {
        return "set_my_profile";
    }

    @Override
    public Response<SetMyProfileResponse> doHandle(Request<SetMyProfileRequest> request) {
        SetMyProfileRequest requestData = request.getData();
        SetMyProfileResponse setMyProfileResponse = new SetMyProfileResponse();

        ProfileDTO profileDTO = requestData.getProfile();
        ProfileEntity profileEntity = mapper.mapRevert(profileDTO, ProfileEntity.class);

        try {
            profileEntity.setId(request.getRoutingData().getProfileId());
            profileService.update(profileEntity);
            return responseFactory.createResponse(request, setMyProfileResponse);
        } catch (Exception e) {
            return responseFactory.createResponse(request, Status.BAD_REQUEST);
        }
    }


}
