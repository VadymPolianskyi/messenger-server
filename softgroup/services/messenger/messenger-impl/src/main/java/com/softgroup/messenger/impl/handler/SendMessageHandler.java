package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.SendMessageRequest;
import com.softgroup.messenger.api.message.SendMessageResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:47
 */
public class SendMessageHandler
        extends AbstractRequestHandler<SendMessageRequest,
            SendMessageResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "getConversationByIds";
    }

    @Override
    public Response<SendMessageResponse> doHandle(Request<SendMessageRequest> request) {
        return null;
    }
}
