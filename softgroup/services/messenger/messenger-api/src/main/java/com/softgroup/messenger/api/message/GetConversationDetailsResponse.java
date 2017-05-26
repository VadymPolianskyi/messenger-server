package com.softgroup.messenger.api.message;


import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationMemberDTO;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:05
 */
public class GetConversationDetailsResponse implements ResponseData {

    private static final long serialVersionUID = 6342099854740397327L;

    private ConversationMemberDTO conversationMemberDTO;

    public ConversationMemberDTO getConversationMemberDTO() {
        return conversationMemberDTO;
    }

    public void setConversationMemberDTO(ConversationMemberDTO conversationMemberDTO) {
        this.conversationMemberDTO = conversationMemberDTO;
    }
}
