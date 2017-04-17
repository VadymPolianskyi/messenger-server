package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationSettingsEntity;
import com.softgroup.common.dao.impl.service.ConversationSettingsService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.dto.ConversationSettingsDTO;
import com.softgroup.messenger.api.message.UpdateConversationSettingsRequest;
import com.softgroup.messenger.api.message.UpdateConversationSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.model.maper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:48
 */
@Component
public class UpdateConversationSettingsHandler
        extends AbstractRequestHandler<UpdateConversationSettingsRequest,
            UpdateConversationSettingsResponse> implements MessengerRequestHandler {

    @Autowired
    private Mapper<ConversationSettingsEntity, ConversationSettingsDTO> mapper;

    @Autowired
    private ConversationSettingsService conversationSettingsService;

    @Override
    public String getName() {
        return "update_conversation_settings";
    }

    @Override
    public Response<UpdateConversationSettingsResponse> doHandle(Request<UpdateConversationSettingsRequest> request) {
        UpdateConversationSettingsRequest requestData = request.getData();
        UpdateConversationSettingsResponse updateConversationSettingsResponse =
                new UpdateConversationSettingsResponse();

        String profileId = request.getRoutingData().getProfileId();
        ConversationSettingsDTO conversationSettingsDTO = requestData.getConversationSettingsDTO();

        ConversationSettingsDTO responseConversationSettings =
                        updateConversationSettings(conversationSettingsDTO, profileId);

        if (responseConversationSettings == null) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        } else {
            updateConversationSettingsResponse.setConversationSettingsDTO(responseConversationSettings);
            return responseFactory.createResponse(request, updateConversationSettingsResponse);
        }
    }

    private ConversationSettingsDTO updateConversationSettings(
                ConversationSettingsDTO conversationSettingsDTO, String profileId) {
        ConversationSettingsEntity conversationSettingsEntity = conversationSettingsService.findByAdminId(profileId);
        String conversatioSettingsId = conversationSettingsEntity.getId();

        conversationSettingsEntity = mapper.mapRevert(conversationSettingsDTO, ConversationSettingsEntity.class);
        conversationSettingsEntity.setId(conversatioSettingsId);

        conversationSettingsService.update(conversationSettingsEntity);

        return mapper.map(conversationSettingsEntity, ConversationSettingsDTO.class);
    }
}
