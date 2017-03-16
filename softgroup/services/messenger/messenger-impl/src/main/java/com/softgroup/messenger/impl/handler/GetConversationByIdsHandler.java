package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationByIdsRequest;
import com.softgroup.messenger.api.message.GetConversationByIdsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:44
 */

@Component
public class GetConversationByIdsHandler
        extends AbstractRequestHandler<GetConversationByIdsRequest,
            GetConversationByIdsResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "get_conversation_by_ids";
    }

    @Override
    public Response<GetConversationByIdsResponse> doHandle(Request<GetConversationByIdsRequest> request) {
        return null;
    }
}
