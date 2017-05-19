package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.impl.service.ConversationMemberService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.dto.ConversationMemberDTO;
import com.softgroup.messenger.api.message.GetConversationsDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationsDetailsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.model.maper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:46
 */
@Component
public class GetConversationsDetailsHandler
        extends AbstractRequestHandler<GetConversationsDetailsRequest,
        GetConversationsDetailsResponse> implements MessengerRequestHandler {

    @Autowired
    private ConversationMemberService conversationMemberService;
    @Autowired
    private Mapper<ConversationMemberEntity, ConversationMemberDTO> mapper;

    @Override
    public String getName() {
        return "get_conversations_details";
    }

    @Override
    public Response<GetConversationsDetailsResponse> doHandle(Request<GetConversationsDetailsRequest> request) {
        GetConversationsDetailsRequest requestData = request.getData();
        GetConversationsDetailsResponse getConversationsDetailsResponse =
                new GetConversationsDetailsResponse();

        List<String> conversationIds = requestData.getConversationIDs();
        List<ConversationMemberDTO> conversationMemberDTOs =
                getConversationsDetails(conversationIds);

        if (conversationMemberDTOs.size() < conversationIds.size()) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        } else {
            getConversationsDetailsResponse.setConversationMemberDTOs(conversationMemberDTOs);
            return responseFactory.createResponse(request, getConversationsDetailsResponse);
        }
    }

    private List<ConversationMemberDTO> getConversationsDetails(List<String> conversationIds) {
        List<ConversationMemberEntity> conversationMemberEntities =
                conversationMemberService.findByConversationIdIn(conversationIds);

        List<ConversationMemberDTO> conversationMemberDTOs = new ArrayList<ConversationMemberDTO>();

        for (ConversationMemberEntity conversationMemberEntity : conversationMemberEntities) {
            conversationMemberDTOs.add(mapper.map(conversationMemberEntity, ConversationMemberDTO.class));
        }
        return conversationMemberDTOs;
    }
}
