package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.impl.service.ConversationMemberService;
import com.softgroup.common.dao.impl.service.ConversationService;
import com.softgroup.common.dao.impl.service.ConversationSettingsService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.DeleteConversationRequest;
import com.softgroup.messenger.api.message.DeleteConversationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:43
 */
@Component
public class DeleteConversationHandler
        extends AbstractRequestHandler<DeleteConversationRequest,
            DeleteConversationResponse> implements MessengerRequestHandler {

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private ConversationSettingsService conversationSettingsService;

    @Autowired
    private ConversationMemberService conversationMemberService;

    @Override
    public String getName() {
        return "delete_convesation";
    }

    @Override
    public Response<DeleteConversationResponse> doHandle(Request<DeleteConversationRequest> request) {
        DeleteConversationRequest requestData = request.getData();
        DeleteConversationResponse deleteConversationResponse = new DeleteConversationResponse();

        String conversationID = requestData.getConversationID();

        if (conversationID == null) {
            return responseFactory.createResponse(request, Status.BAD_REQUEST);
        }

        deleteConversation(conversationID);
        return responseFactory.createResponse(request, deleteConversationResponse);
    }

    private void deleteConversation(String conversationID) {
        conversationMemberService.deleteByConversationId(conversationID);
        conversationSettingsService.deleteByConversationId(conversationID);
        conversationService.delete(conversationID);
    }
}
