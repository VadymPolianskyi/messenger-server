package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationDetailsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:45
 */
@Component
public class GetConversationDetailsHandler extends AbstractRequestHandler<GetConversationDetailsRequest,
        GetConversationDetailsResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "get_conversation_entity_details";
    }

    @Override
    public Response<GetConversationDetailsResponse> doHandle(Request<GetConversationDetailsRequest> request) {
        return null;
    }
}
