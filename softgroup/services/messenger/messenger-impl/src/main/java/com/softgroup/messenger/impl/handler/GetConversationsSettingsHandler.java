package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationSettingsEntity;
import com.softgroup.common.dao.impl.service.ConversationSettingsService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.dto.ConversationSettingsDTO;
import com.softgroup.messenger.api.message.GetConversationsSettingsRequest;
import com.softgroup.messenger.api.message.GetConversationsSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.model.maper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:45
 */
@Component
public class GetConversationsSettingsHandler
        extends AbstractRequestHandler<GetConversationsSettingsRequest,
        GetConversationsSettingsResponse> implements MessengerRequestHandler {

    @Autowired
    private ConversationSettingsService conversationSettingsService;
    @Autowired
    private Mapper<ConversationSettingsEntity, ConversationSettingsDTO> mapper;

    @Override
    public String getName() {
        return "get_conversations_setting";
    }

    @Override
    public Response<GetConversationsSettingsResponse> doHandle(Request<GetConversationsSettingsRequest> request) {
        GetConversationsSettingsRequest requestData = request.getData();
        GetConversationsSettingsResponse getConversationsSettingsResponse =
                new GetConversationsSettingsResponse();

        List<String> conversationIds = requestData.getConversationsIDs();
        List<ConversationSettingsDTO> conversationSettingsDTOs =
                getConversationsSettings(conversationIds);

        if (conversationSettingsDTOs.size() < conversationIds.size()) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        } else {
            getConversationsSettingsResponse.setConversationSettingsDTOS(conversationSettingsDTOs);
            return responseFactory.createResponse(request, getConversationsSettingsResponse);
        }
    }

    private List<ConversationSettingsDTO> getConversationsSettings(List<String> conversationIds) {
        List<ConversationSettingsEntity> conversationSettingsEntities =
                conversationSettingsService.findByConversationIdIn(conversationIds);

        List<ConversationSettingsDTO> conversationSettingsDTOs = new ArrayList<ConversationSettingsDTO>();

        for (ConversationSettingsEntity conversationSettingsEntity : conversationSettingsEntities) {
            conversationSettingsDTOs.add(mapper.map(conversationSettingsEntity, ConversationSettingsDTO.class));
        }
        return conversationSettingsDTOs;
    }
}
