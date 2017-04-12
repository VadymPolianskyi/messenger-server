package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.service.ProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
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
        Response<SetMyProfileResponse> response = new Response<SetMyProfileResponse>();
        response.setHeader(request.getHeader());
        response.setData(setMyProfileResponse);
        ResponseStatus status = new ResponseStatus();

        try {
            ProfileEntity profileEntity = (ProfileEntity) mapper.mapRevert(profileDTO, ProfileEntity.class);
            profileEntity.setId(request.getRoutingData().getProfileId());
            profileService.save(profileEntity);
            status.setCode(200);
            status.setMessage("OK");
            response.setStatus(status);
            return response;
        } catch (Exception e) {
            status.setCode(500);
            status.setMessage("ERROR");
            response.setStatus(status);
            return response;
        }
    }


}
