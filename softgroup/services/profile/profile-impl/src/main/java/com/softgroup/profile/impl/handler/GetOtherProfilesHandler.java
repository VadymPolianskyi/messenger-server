package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.impl.service.ProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.model.maper.Mapper;
import com.softgroup.model.maper.ProfileDTO;
import com.softgroup.profile.api.message.GetOtherProfilesRequest;
import com.softgroup.profile.api.message.GetOtherProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:46
 */
@Component
public class GetOtherProfilesHandler
        extends AbstractRequestHandler<GetOtherProfilesRequest,
            GetOtherProfilesResponse> implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private Mapper mapper;

    public String getName() {
        return "get_other_profiles";
    }

    @Override
    public Response<GetOtherProfilesResponse> doHandle(Request<GetOtherProfilesRequest> request) {
        GetOtherProfilesRequest requestData = request.getData();
        GetOtherProfilesResponse getOtherProfilesResponse = new GetOtherProfilesResponse();


        List<String> uuids = requestData.getUserID();
        List<ProfileDTO> profileDTOS = getProfileDTOs(uuids);

        getOtherProfilesResponse.setProfileDTOS(profileDTOS);

        Response<GetOtherProfilesResponse> response = new Response<GetOtherProfilesResponse>();
        response.setHeader(request.getHeader());
        response.setData(getOtherProfilesResponse);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");

        response.setStatus(status);
        return response;
    }

    private List<ProfileDTO> getProfileDTOs(List<String> uuids) {
        List<ProfileDTO> profileDTOS = new ArrayList<>();

        for (String uuid : uuids) {
            profileDTOS.add(mapper.mapProfile(profileService.findProfileById(uuid)));
        }

        return profileDTOS;
    }
}
