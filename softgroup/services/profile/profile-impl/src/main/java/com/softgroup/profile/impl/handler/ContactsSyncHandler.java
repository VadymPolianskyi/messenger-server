package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.ContactsSyncRequest;
import com.softgroup.profile.api.message.ContactsSyncResponse;
import com.softgroup.profile.api.router.*;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:41
 */
@Component
public class ContactsSyncHandler
        extends AbstractRequestHandler<ContactsSyncRequest,
                ContactsSyncResponse> implements ProfileRequestHandler {
    public String getName() {
        return null;
    }

    @Override
    public Response<ContactsSyncResponse> doHandle(Request<ContactsSyncRequest> request) {
        return null;
    }
}
