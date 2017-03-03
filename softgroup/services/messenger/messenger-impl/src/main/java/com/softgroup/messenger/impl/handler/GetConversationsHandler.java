package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsRequest;
import com.softgroup.messenger.api.message.GetConversationsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:46
 */
public class GetConversationsHandler
        extends AbstractRequestHandler<GetConversationsRequest,
            GetConversationsResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "getConversationByIds";
    }

    @Override
    public Response<GetConversationsResponse> doHandle(Request<GetConversationsRequest> request) {
        return null;
    }
}
