package com.softgroup.messenger.api.message;


import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationSettingsDTO;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:09
 */
public class GetConversationSettingsResponse implements ResponseData {
    private ConversationSettingsDTO conversationSettingsDTO;

    public ConversationSettingsDTO getConversationSettingsDTO() {
        return conversationSettingsDTO;
    }

    public void setConversationSettingsDTO(ConversationSettingsDTO conversationSettingsDTO) {
        this.conversationSettingsDTO = conversationSettingsDTO;
    }
}
