package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetMessagesRequest;
import com.softgroup.messenger.api.message.GetMessagesResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:47
 */
@Component
public class GetMessagesHandler
        extends AbstractRequestHandler<GetMessagesRequest,
            GetMessagesResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "get_messages";
    }

    @Override
    public Response<GetMessagesResponse> doHandle(Request<GetMessagesRequest> request) {
        return null;
    }
}
