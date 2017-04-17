package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.dao.api.entities.MessageStatusEntity;
import com.softgroup.common.dao.api.entities.types.MessageStatus;
import com.softgroup.common.dao.impl.service.MessageService;
import com.softgroup.common.dao.impl.service.MessageStatusService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.dto.MessageDTO;
import com.softgroup.messenger.api.message.SendMessageRequest;
import com.softgroup.messenger.api.message.SendMessageResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.model.maper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:47
 */
@Component
public class SendMessageHandler
        extends AbstractRequestHandler<SendMessageRequest,
            SendMessageResponse> implements MessengerRequestHandler {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageStatusService messageStatusService;

    @Autowired
    private Mapper<MessageEntity, MessageDTO> mapper;

    @Override
    public String getName() {
        return "send_message";
    }

    @Override
    public Response<SendMessageResponse> doHandle(Request<SendMessageRequest> request) {
        SendMessageRequest requestData = request.getData();
        SendMessageResponse sendMessageResponse =
                new SendMessageResponse();

        String profileId = request.getRoutingData().getProfileId();
        MessageDTO messageDTO = requestData.getMessage();

        MessageDTO responseMessage = sendMessage(messageDTO);

        if (responseMessage == null) {
            return responseFactory.createResponse(request, Status.BAD_REQUEST);
        } else {
            sendMessageResponse.setMessage(responseMessage);
            return responseFactory.createResponse(request, sendMessageResponse);
        }
    }

    private MessageDTO sendMessage(MessageDTO messageDTO) {
        MessageEntity messageEntity = mapper.mapRevert(messageDTO, MessageEntity.class);
        messageEntity.setServerRecDate(System.currentTimeMillis());
        messageEntity = messageService.add(messageEntity);

        MessageStatusEntity messageStatusEntity = new MessageStatusEntity();
        messageStatusEntity.setMessageId(messageEntity.getId());
        messageStatusEntity.setSenderId(messageEntity.getSenderId());
        messageStatusEntity.setConversationId(messageEntity.getConversationId());
        messageStatusEntity.setStatus(MessageStatus.UNREAD);

        messageStatusService.add(messageStatusEntity);

        return mapper.map(messageEntity, MessageDTO.class);
    }


}
