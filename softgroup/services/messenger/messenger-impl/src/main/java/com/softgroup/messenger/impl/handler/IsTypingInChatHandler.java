package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.IsTypingInChatRequest;
import com.softgroup.messenger.api.message.IsTypingInChatResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:47
 */
@Component
public class IsTypingInChatHandler
        extends AbstractRequestHandler<IsTypingInChatRequest,
            IsTypingInChatResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "get_conversation_by_ids";
    }

    @Override
    public Response<IsTypingInChatResponse> doHandle(Request<IsTypingInChatRequest> request) {
        return null;
    }
}
