package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.api.entities.types.ConversationType;
import com.softgroup.common.dao.impl.service.ConversationMemberService;
import com.softgroup.common.dao.impl.service.ConversationService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsRequest;
import com.softgroup.messenger.api.message.GetConversationsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.model.maper.Mapper;
import com.softgroup.profile.api.dto.ConversationDTO;
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
public class GetConversationsHandler
        extends AbstractRequestHandler<GetConversationsRequest,
            GetConversationsResponse> implements MessengerRequestHandler {

    @Autowired
    private ConversationMemberService conversationMemberService;

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private Mapper<ConversationEntity, ConversationDTO> mapper;

    @Override
    public String getName() {
        return "get_conversations";
    }

    @Override
    public Response<GetConversationsResponse> doHandle(Request<GetConversationsRequest> request) {
        GetConversationsRequest requestData = request.getData();
        GetConversationsResponse getConversationsResponse =
                new GetConversationsResponse();

        String profileId = request.getRoutingData().getProfileId();
        ConversationType conversationType = requestData.getType();
        List<ConversationDTO> conversationDTOS = getConversationDTO(conversationType, profileId);

        if (conversationDTOS.size() == 0) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        } else {
            getConversationsResponse.setConversationDTOs(conversationDTOS);
            return responseFactory.createResponse(request, getConversationsResponse);
        }
    }

    private List<ConversationDTO> getConversationDTO(ConversationType conversationType,
                                                        String profileId) {
        List<ConversationDTO> conversationDTOs = new ArrayList<ConversationDTO>();
        List<ConversationMemberEntity> conversationMemberEntities =
                        conversationMemberService.findByProfileId(profileId);
        List<String> conversationIds = new ArrayList<String>();
        for (ConversationMemberEntity conversationMemberEntity : conversationMemberEntities) {
            conversationIds.add(conversationMemberEntity.getConversationId());
        }

        List<ConversationEntity> conversationEntities;
        if(conversationType != null) {
            conversationEntities = conversationService
                                .findByTypeAndIdIn(conversationType, conversationIds);
        } else {
            conversationEntities = conversationService.findConversationsByIds(conversationIds);
        }

        for (ConversationEntity conversationEntity : conversationEntities) {
            conversationDTOs.add(mapper.map(conversationEntity, ConversationDTO.class));
        }
        return conversationDTOs;
    }
}