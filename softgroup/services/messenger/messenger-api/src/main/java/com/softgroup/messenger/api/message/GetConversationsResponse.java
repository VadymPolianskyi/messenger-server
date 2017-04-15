package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ConversationDTO;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:21
 */
public class GetConversationsResponse implements ResponseData {
    private List<ConversationDTO> conversationDTOs;

    public List<ConversationDTO> getConversationDTOs() {
        return conversationDTOs;
    }

    public void setConversationDTOs(List<ConversationDTO> conversationDTOs) {
        this.conversationDTOs = conversationDTOs;
    }
}
