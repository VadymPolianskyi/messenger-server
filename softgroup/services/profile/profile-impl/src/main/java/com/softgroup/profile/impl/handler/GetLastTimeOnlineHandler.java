package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.last.time.online.service.LastTimeOnlineService;
import com.softgroup.model.maper.ProfileDTO;
import com.softgroup.profile.api.ProfileStatusDTO;
import com.softgroup.profile.api.message.GetLastTimeOnlineRequest;
import com.softgroup.profile.api.message.GetLastTimeOnlineResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:48
 */
@Component
public class GetLastTimeOnlineHandler
        extends AbstractRequestHandler<GetLastTimeOnlineRequest,
            GetLastTimeOnlineResponse> implements ProfileRequestHandler {
    public String getName() {
        return "get_last_time_online";
    }

    @Autowired
    private LastTimeOnlineService lastTimeOnlineService;

    @Override
    public Response<GetLastTimeOnlineResponse> doHandle(Request<GetLastTimeOnlineRequest> request) {
        GetLastTimeOnlineRequest requestData = request.getData();
        GetLastTimeOnlineResponse getLastTimeOnlineResponse = new GetLastTimeOnlineResponse();

        List<String> profileIds = requestData.getProfilesUUID();
        List<ProfileStatusDTO>  profileStatusDTOS = getProfileStatusDTOs(profileIds);
        getLastTimeOnlineResponse.setProfileStatusDTOS(profileStatusDTOS);

        if (profileStatusDTOS.size() == 0) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        } else {
            return responseFactory.createResponse(request, getLastTimeOnlineResponse);
        }
    }

    private List<ProfileStatusDTO> getProfileStatusDTOs(List<String> profileIds) {
        List<ProfileStatusDTO> profileStatusDTOS = new ArrayList<>();
        List<Long> lastTimeOnline = lastTimeOnlineService.getLastTimeOnline(profileIds);
        for (String profileId : profileIds) {
            profileStatusDTOS.add(new ProfileStatusDTO(profileId, lastTimeOnline.remove(0)));
        }
        return profileStatusDTOS;
    }
}
