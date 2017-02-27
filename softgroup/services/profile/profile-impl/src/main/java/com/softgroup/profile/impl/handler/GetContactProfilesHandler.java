package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetContactProfilesRequest;
import com.softgroup.profile.api.message.GetContactProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:44
 */
@Component
public class GetContactProfilesHandler
        extends AbstractRequestHandler<GetContactProfilesRequest,
            GetContactProfilesResponse> implements ProfileRequestHandler {

    public String getName() {
        return null;
    }


    @Override
    public Response<GetContactProfilesResponse> doHandle(Request<GetContactProfilesRequest> request) {
        return null;
    }
}
