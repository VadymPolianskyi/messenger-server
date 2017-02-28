package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.UpdateConversationSettingsRequest;
import com.softgroup.messenger.api.message.UpdateConversationSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:48
 */
public class UpdateConversationSettingsHandler
        extends AbstractRequestHandler<UpdateConversationSettingsRequest,
            UpdateConversationSettingsResponse> implements MessengerRequestHandler {
    @Override
    public String getName() {
        return "getConversationByIds";
    }

    @Override
    public Response<UpdateConversationSettingsResponse> doHandle(Request<UpdateConversationSettingsRequest> request) {
        return null;
    }
}
