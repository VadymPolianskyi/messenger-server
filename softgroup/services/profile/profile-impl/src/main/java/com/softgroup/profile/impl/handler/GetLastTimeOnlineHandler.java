package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetLastTimeOnlineRequest;
import com.softgroup.profile.api.message.GetLastTimeOnlineResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

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
        return null;
    }


    @Override
    public Response<GetLastTimeOnlineResponse> doHandle(Request<GetLastTimeOnlineRequest> request) {
        return null;
    }
}
