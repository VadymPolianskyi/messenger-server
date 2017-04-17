package com.softgroup.messenger.api.message;


import com.softgroup.common.protocol.RequestData;
import com.softgroup.messenger.api.dto.ConversationSettingsDTO;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:16
 */
public class UpdateConversationSettingsRequest implements RequestData {

    private ConversationSettingsDTO conversationSettingsDTO;

    public ConversationSettingsDTO getConversationSettingsDTO() {
        return conversationSettingsDTO;
    }

    public void setConversationSettingsDTO(ConversationSettingsDTO conversationSettingsDTO) {
        this.conversationSettingsDTO = conversationSettingsDTO;
    }
}
