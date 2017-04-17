package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.dao.impl.service.ConversationMemberService;
import com.softgroup.common.dao.impl.service.MessageService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.dto.MessageDTO;
import com.softgroup.messenger.api.message.GetMessagesRequest;
import com.softgroup.messenger.api.message.GetMessagesResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.model.maper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:47
 */
@Component
public class GetMessagesHandler
        extends AbstractRequestHandler<GetMessagesRequest,
            GetMessagesResponse> implements MessengerRequestHandler {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ConversationMemberService conversationMemberService;

    @Autowired
    private Mapper<MessageEntity, MessageDTO> mapper;

    @Override
    public String getName() {
        return "get_messages";
    }

    @Override
    public Response<GetMessagesResponse> doHandle(Request<GetMessagesRequest> request) {
        GetMessagesRequest requestData = request.getData();
        GetMessagesResponse getMessagesResponse =
                new GetMessagesResponse();

        MessageDTO cursor = requestData.getCursor();
        String conversationId = requestData.getConversationID();
        String profileId = request.getRoutingData().getProfileId();

        List<MessageEntity> messagesAfterCursor = messageService
                .findByCreateDateGreaterThanAndConversationId(cursor.getCreateDate(), conversationId);
        int totalUnread = messagesAfterCursor.size();

        MessageDTO newCursor = mapper.map(messagesAfterCursor.get(totalUnread-1), MessageDTO.class);

        getMessagesResponse.setTotalUnread(totalUnread);
        getMessagesResponse.setCursor(newCursor);
        getMessagesResponse.setMessageEntities(getAllMessages(conversationId, profileId));
        return responseFactory.createResponse(request, getMessagesResponse);
    }

    private List<MessageDTO> getAllMessages(String conversationId, String profileID) {
        List<MessageDTO> messageDTOs = new ArrayList<MessageDTO>();
        ConversationMemberEntity conversationMemberEntity = conversationMemberService
                                .findByConversationIdAndProfileId(conversationId, profileID);

        Long joinDate = conversationMemberEntity.getJoinDate();
        List<MessageEntity> messagesAfterCursor = messageService
                .findByCreateDateGreaterThanAndConversationId(joinDate, conversationId);

        for (MessageEntity messageEntity : messagesAfterCursor) {
            messageDTOs.add(mapper.map(messageEntity, MessageDTO.class));
        }
        return messageDTOs;
    }
}
