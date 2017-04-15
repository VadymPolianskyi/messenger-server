package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.types.ConversationType;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsRequest;
import com.softgroup.messenger.api.message.GetConversationsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.profile.api.dto.ConversationDTO;
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

        if (conversationDTOS.size() < conversationIds.size()) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        } else {
            getConversationByIdsResponse.setConversationDTOS(conversationDTOS);
            return responseFactory.createResponse(request, getConversationByIdsResponse);
        }
    }

    private List<ConversationDTO> getConversationDTO(ConversationType conversationType,
                                                        String profileId) {
        List<ConversationDTO> conversationDTOs = new ArrayList<ConversationDTO>();
    }
}