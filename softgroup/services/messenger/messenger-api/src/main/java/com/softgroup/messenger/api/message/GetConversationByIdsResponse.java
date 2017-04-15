package com.softgroup.messenger.api.message;


import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ConversationDTO;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:14
 */
public class GetConversationByIdsResponse implements ResponseData {
    private List<ConversationDTO> conversationDTOS;

    public List<ConversationDTO> getConversationDTOS() {
        return conversationDTOS;
    }

    public void setConversationDTOS(List<ConversationDTO> conversationDTOS) {
        this.conversationDTOS = conversationDTOS;
    }
}
