package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:45
 */
@Component
public class GetMyProfileHandler implements ProfileRequestHandler {
    public String getName() {
        return null;
    }

    public Response<?> handle(Request<?> msg) {
        return null;
    }
}
