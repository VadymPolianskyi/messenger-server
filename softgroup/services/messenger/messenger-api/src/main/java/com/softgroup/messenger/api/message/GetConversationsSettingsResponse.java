package com.softgroup.messenger.api.message;


import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationSettingsDTO;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:12
 */
public class GetConversationsSettingsResponse implements ResponseData {
    private List<ConversationSettingsDTO> conversationSettingsDTOS;

    public List<ConversationSettingsDTO> getConversationSettingsDTOS() {
        return conversationSettingsDTOS;
    }

    public void setConversationSettingsDTOS(List<ConversationSettingsDTO> conversationSettingsDTOS) {
        this.conversationSettingsDTOS = conversationSettingsDTOS;
    }
}
