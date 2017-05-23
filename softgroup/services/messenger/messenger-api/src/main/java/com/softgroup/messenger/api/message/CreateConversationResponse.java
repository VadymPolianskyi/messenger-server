package com.softgroup.messenger.api.message;


import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ConversationDTO;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:13
 */
public class CreateConversationResponse implements ResponseData {

    private static final long serialVersionUID = 9040535248829292573L;

    private ConversationDTO conversationDTO;

    public ConversationDTO getConversationDTO() {
        return conversationDTO;
    }

    public void setConversationDTO(ConversationDTO conversationDTO) {
        this.conversationDTO = conversationDTO;
    }
}
