package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.CreateConversationRequest;
import com.softgroup.messenger.api.message.CreateConversationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 13:16
 */@Component
public class CreateConversationHandler
        extends AbstractRequestHandler<CreateConversationRequest,
            CreateConversationResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "createConversation";
    }


    public Response<CreateConversationResponse> doHandle(Request<CreateConversationRequest> request) {
        return null;
    }
}
