package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetOtherProfilesRequest;
import com.softgroup.profile.api.message.GetOtherProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:46
 */
@Component
public class GetOtherProfilesHandler
        extends AbstractRequestHandler<GetOtherProfilesRequest,
            GetOtherProfilesResponse> implements ProfileRequestHandler {
    public String getName() {
        return "get_other_profiles";
    }

    @Override
    public Response<GetOtherProfilesResponse> doHandle(Request<GetOtherProfilesRequest> request) {
        return null;
    }
}
