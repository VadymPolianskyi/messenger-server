package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationSettingsRequest;
import com.softgroup.messenger.api.message.GetConversationSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:46
 */
public class GetConversationSettingsHandler
        extends AbstractRequestHandler<GetConversationSettingsRequest,
            GetConversationSettingsResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "getConversationByIds";
    }

    @Override
    public Response<GetConversationSettingsResponse> doHandle(Request<GetConversationSettingsRequest> request) {
        return null;
    }
}
