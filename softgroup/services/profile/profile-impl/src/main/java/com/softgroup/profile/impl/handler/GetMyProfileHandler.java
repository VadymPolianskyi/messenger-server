package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.service.ProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetMyProfileRequest;
import com.softgroup.profile.api.message.GetMyProfileResponse;
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
public class GetMyProfileHandler
        extends AbstractRequestHandler<GetMyProfileRequest,
            GetMyProfileResponse> implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    public String getName() {
        return "get_my_profile";
    }

    @Override
    public Response<GetMyProfileResponse> doHandle(Request<GetMyProfileRequest> request) {
        GetMyProfileRequest requestData = request.getData();
        GetMyProfileResponse getMyProfileResponse = new GetMyProfileResponse();

        String profileId = request.getRoutingData().getProfileId();

        ProfileEntity profileEntity = profileService.findProfileById(profileId);

        getMyProfileResponse.setProfileEntity(profileEntity);

        Response<GetMyProfileResponse> response = new Response<GetMyProfileResponse>();
        response.setHeader(request.getHeader());
        response.setData(getMyProfileResponse);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");

        response.setStatus(status);
        return response;
    }
}
