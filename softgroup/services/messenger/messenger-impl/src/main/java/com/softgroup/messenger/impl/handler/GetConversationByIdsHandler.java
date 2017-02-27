package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationByIdsRequest;
import com.softgroup.messenger.api.message.GetConversationByIdsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:44
 */
public class GetConversationByIdsHandler
        extends AbstractRequestHandler<GetConversationByIdsRequest,
            GetConversationByIdsResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "getConversationByIds";
    }

    @Override
    public Response<GetConversationByIdsResponse> doHandle(Request<GetConversationByIdsRequest> request) {
        return null;
    }
}
