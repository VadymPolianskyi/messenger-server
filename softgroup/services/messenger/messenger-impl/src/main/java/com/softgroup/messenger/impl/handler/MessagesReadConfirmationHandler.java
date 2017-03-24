package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.MessagesReadConfirmationRequest;
import com.softgroup.messenger.api.message.MessagesReadConfirmationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:47
 */
@Component
public class MessagesReadConfirmationHandler extends AbstractRequestHandler<MessagesReadConfirmationRequest,
        MessagesReadConfirmationResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "message_read_comfirmation";
    }

    @Override
    public Response<MessagesReadConfirmationResponse> doHandle(Request<MessagesReadConfirmationRequest> request) {
        return null;
    }
}
