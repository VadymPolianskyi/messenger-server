package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.service.ProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.model.maper.Mapper;
import com.softgroup.profile.api.dto.ProfileDTO;
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
    private Mapper<ProfileEntity, ProfileDTO> mapper;

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

        return responseFactory.createResponse(request, getOtherProfilesResponse);
    }

    private List<ProfileDTO> getProfileDTOs(List<String> uuids) {
        List<ProfileDTO> profileDTOS = new ArrayList<>();
        List<ProfileEntity> profileEntities = profileService.findByArrayOfIds(uuids);

        for (ProfileEntity profileEntity : profileEntities) {
            profileDTOS.add(mapper.map(profileEntity, ProfileDTO.class));
        }
        return profileDTOS;
    }
}
