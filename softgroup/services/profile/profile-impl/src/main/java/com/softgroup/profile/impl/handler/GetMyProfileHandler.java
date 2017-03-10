package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetMyProfileRequest;
import com.softgroup.profile.api.message.GetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
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
    public String getName() {
        return "get_my_profile";
    }

    @Override
    public Response<GetMyProfileResponse> doHandle(Request<GetMyProfileRequest> request) {
        return null;
    }
}
