package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.dao.api.entities.MessageStatusEntity;
import com.softgroup.common.dao.api.entities.types.MessageStatus;
import com.softgroup.common.dao.impl.service.ConversationMemberService;
import com.softgroup.common.dao.impl.service.MessageService;
import com.softgroup.common.dao.impl.service.MessageStatusService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.MessagesReadConfirmationRequest;
import com.softgroup.messenger.api.message.MessagesReadConfirmationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:47
 */
@Component
public class MessagesReadConfirmationHandler extends AbstractRequestHandler<MessagesReadConfirmationRequest,
        MessagesReadConfirmationResponse> implements MessengerRequestHandler {

    @Autowired
    private MessageStatusService messageStatusService;

    @Override
    public String getName() {
        return "message_read_comfirmation";
    }

    @Override
    public Response<MessagesReadConfirmationResponse> doHandle(Request<MessagesReadConfirmationRequest> request) {
        MessagesReadConfirmationRequest requestData = request.getData();
        MessagesReadConfirmationResponse messagesReadConfirmationResponse =
                new MessagesReadConfirmationResponse();

        String profileId = request.getRoutingData().getProfileId();
        String conversationID = requestData.getConversationID();
        List<String> messagesIDs = requestData.getMessagesIDs();

        setStatusReaded(messagesIDs, profileId, conversationID);

        return responseFactory.createResponse(request, messagesReadConfirmationResponse);
    }

    private void setStatusReaded(List<String> messagesIds, String profileId, String conversationId) {
        for (String messageId : messagesIds) {
            MessageStatusEntity messageStatusEntity =
                    messageStatusService.findByMessageId(messageId);
            messageStatusEntity.setStatus(MessageStatus.READ);
            messageStatusService.update(messageStatusEntity);
        }
    }
}
