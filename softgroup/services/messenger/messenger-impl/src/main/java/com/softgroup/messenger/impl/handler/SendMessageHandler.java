package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.SendMessageRequest;
import com.softgroup.messenger.api.message.SendMessageResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:47
 */
@Component
public class SendMessageHandler
        extends AbstractRequestHandler<SendMessageRequest,
            SendMessageResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "get_conversation_by_ids";
    }

    @Override
    public Response<SendMessageResponse> doHandle(Request<SendMessageRequest> request) {
        return null;
    }
}
