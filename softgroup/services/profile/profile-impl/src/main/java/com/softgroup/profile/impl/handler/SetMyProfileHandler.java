package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.SetMyProfileRequest;
import com.softgroup.profile.api.message.SetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
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
    public String getName() {
        return null;
    }

    @Override
    public Response<SetMyProfileResponse> doHandle(Request<SetMyProfileRequest> request) {
        return null;
    }
}
