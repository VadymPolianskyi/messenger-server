package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationSettingsEntity;
import com.softgroup.common.dao.impl.service.ConversationSettingsService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.dto.ConversationSettingsDTO;
import com.softgroup.messenger.api.message.GetConversationDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationDetailsResponse;
import com.softgroup.messenger.api.message.GetConversationSettingsRequest;
import com.softgroup.messenger.api.message.GetConversationSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.model.maper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:45
 */
@Component
public class GetConversationSettingsHandler extends AbstractRequestHandler<GetConversationSettingsRequest,
        GetConversationSettingsResponse> implements MessengerRequestHandler {

    @Autowired
    private ConversationSettingsService conversationSettingsService;
    @Autowired
    private Mapper<ConversationSettingsEntity, ConversationSettingsDTO> mapper;

    @Override
    public String getName() {
        return "get_conversation_settings";
    }

    @Override
    public Response<GetConversationSettingsResponse> doHandle(Request<GetConversationSettingsRequest> request) {
        GetConversationSettingsRequest requestData = request.getData();
        GetConversationSettingsResponse getConversationSettingsResponse =
                new GetConversationSettingsResponse();

        String conversationId = requestData.getConversationID();
        ConversationSettingsEntity conversationSettingsEntity =
                conversationSettingsService.findByConversationId(conversationId);

        ConversationSettingsDTO conversationSettingsDTO =
                    mapper.map(conversationSettingsEntity, ConversationSettingsDTO.class);
        if (conversationSettingsDTO == null) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        } else {
            getConversationSettingsResponse.setConversationSettingsDTO(conversationSettingsDTO);
            return responseFactory.createResponse(request, getConversationSettingsResponse);
        }
    }
}