package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.impl.service.ConversationMemberService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.Status;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.dto.ConversationMemberDTO;
import com.softgroup.messenger.api.message.GetConversationDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationDetailsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.model.maper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:46
 */
@Component
public class GetConversationDetailsHandler
        extends AbstractRequestHandler<GetConversationDetailsRequest,
        GetConversationDetailsResponse> implements MessengerRequestHandler {

    @Autowired
    private ConversationMemberService conversationMemberService;

    @Autowired
    private Mapper<ConversationMemberEntity, ConversationMemberDTO> mapper;

    @Override
    public String getName() {
        return "get_conversation_details";
    }

    @Override
    public Response<GetConversationDetailsResponse> doHandle(Request<GetConversationDetailsRequest> request) {
        GetConversationDetailsRequest requestData = request.getData();
        GetConversationDetailsResponse getConversationDetailsResponse =
                new GetConversationDetailsResponse();

        String conversationId = requestData.getConversationID();
        ConversationMemberEntity conversationMemberEntity =
                conversationMemberService.findByConversationId(conversationId);

        ConversationMemberDTO conversationMemberDTO =
                mapper.map(conversationMemberEntity, ConversationMemberDTO.class);
        if (conversationMemberDTO == null) {
            return responseFactory.createResponse(request, Status.NOT_FOUND);
        } else {
            getConversationDetailsResponse.setConversationMemberDTO(conversationMemberDTO);
            return responseFactory.createResponse(request, getConversationDetailsResponse);
        }
    }
}
