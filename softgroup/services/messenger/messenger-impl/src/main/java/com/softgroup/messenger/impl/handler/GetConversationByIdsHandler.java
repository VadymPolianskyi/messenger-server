package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.impl.service.ConversationService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationByIdsRequest;
import com.softgroup.messenger.api.message.GetConversationByIdsResponse;
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
 * Time: 19:44
 */

@Component
public class GetConversationByIdsHandler
        extends AbstractRequestHandler<GetConversationByIdsRequest,
            GetConversationByIdsResponse> implements MessengerRequestHandler {

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private Mapper<ConversationEntity, ConversationDTO> mapper;

    @Override
    public String getName() {
        return "get_conversation_by_ids";
    }

    @Override
    public Response<GetConversationByIdsResponse> doHandle(Request<GetConversationByIdsRequest> request) {
        GetConversationByIdsRequest requestData = request.getData();
        GetConversationByIdsResponse getConversationByIdsResponse =
                                            new GetConversationByIdsResponse();

        List<String> conversationIds = requestData.getConversationIDs();

        if (conversationIds == null) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        } else {
            List<ConversationDTO> conversationDTOS = getConversationDTO(conversationIds);
            getConversationByIdsResponse.setConversationDTOS(conversationDTOS);
            return responseFactory.createResponse(request, getConversationByIdsResponse);
        }
    }

    private List<ConversationDTO> getConversationDTO(List<String> conversationIDs){
        List<ConversationDTO> conversationDTOList = new ArrayList<ConversationDTO>();
        List<ConversationEntity> conversationEntities =
                conversationService.findConversationsByIds(conversationIDs);

        for (ConversationEntity conversationEntity : conversationEntities) {
            conversationDTOList.add(mapper.map(conversationEntity, ConversationDTO.class));
        }
        return conversationDTOList;
    }
}
