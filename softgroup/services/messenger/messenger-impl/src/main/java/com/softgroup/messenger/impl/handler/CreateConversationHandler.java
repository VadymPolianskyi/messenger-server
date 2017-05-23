package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.api.entities.ConversationSettingsEntity;
import com.softgroup.common.dao.api.entities.types.ConversationType;
import com.softgroup.common.dao.impl.service.ConversationMemberService;
import com.softgroup.common.dao.impl.service.ConversationService;
import com.softgroup.common.dao.impl.service.ConversationSettingsService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.CreateConversationRequest;
import com.softgroup.messenger.api.message.CreateConversationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.model.maper.Mapper;
import com.softgroup.profile.api.dto.ConversationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 13:16
 */@Component
public class CreateConversationHandler
        extends AbstractRequestHandler<CreateConversationRequest,
            CreateConversationResponse> implements MessengerRequestHandler {

     @Autowired
     private ConversationService conversationService;

     @Autowired
     private ConversationMemberService conversationMemberService;

     @Autowired
     private ConversationSettingsService conversationSettingsService;

     @Autowired
     private Mapper<ConversationEntity, ConversationDTO> mapper;

    @Override
    public String getName() {
        return "create_conversation";
    }


    public Response<CreateConversationResponse> doHandle(Request<CreateConversationRequest> request) {
        CreateConversationRequest requestData = request.getData();
        CreateConversationResponse createConversationResponse = new CreateConversationResponse();

        ConversationType type = requestData.getType();
        List<String> membersIDs = requestData.getMembersIDs();
        String profileId = request.getRoutingData().getProfileId();

        if (type == null && membersIDs == null && membersIDs.size() < 2) {
            return responseFactory.createResponse(request, Status.BAD_REQUEST);
        }

        ConversationDTO conversationDTO = createConversation(type, membersIDs, profileId);

        createConversationResponse.setConversationDTO(conversationDTO);
        return responseFactory.createResponse(request, createConversationResponse);
    }

    private ConversationDTO createConversation(ConversationType type,
                                               List<String> membersIDs, String authorId) {

        Long currentTime = System.currentTimeMillis();
        ConversationEntity conversationEntity = new ConversationEntity();
        conversationEntity.setCreationDate(currentTime);
        conversationEntity.setType(type);
        conversationEntity = conversationService.save(conversationEntity);

        String conversationId = conversationEntity.getId();


        for (String membersID : membersIDs) {
            ConversationMemberEntity conversationMemberEntity = new ConversationMemberEntity();
            conversationMemberEntity.setProfileId(membersID);
            conversationMemberEntity.setJoinDate(currentTime);
            conversationMemberEntity.setConversationId(conversationId);
            conversationMemberService.save(conversationMemberEntity);
        }

        ConversationSettingsEntity conversationSettingsEntity = new ConversationSettingsEntity();
        conversationSettingsEntity.setConversationId(conversationId);
        conversationSettingsEntity.setAdminId(authorId);
        conversationSettingsService.save(conversationSettingsEntity);
        return mapper.map(conversationEntity, ConversationDTO.class);
    }
}
