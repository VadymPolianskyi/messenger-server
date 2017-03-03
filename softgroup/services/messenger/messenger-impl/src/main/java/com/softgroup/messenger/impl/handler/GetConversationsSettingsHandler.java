package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsSettingsRequest;
import com.softgroup.messenger.api.message.GetConversationsSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:46
 */
public class GetConversationsSettingsHandler
        extends AbstractRequestHandler<GetConversationsSettingsRequest,
            GetConversationsSettingsResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "getConversationByIds";
    }

    @Override
    public Response<GetConversationsSettingsResponse> doHandle(Request<GetConversationsSettingsRequest> request) {
        return null;
    }
}
