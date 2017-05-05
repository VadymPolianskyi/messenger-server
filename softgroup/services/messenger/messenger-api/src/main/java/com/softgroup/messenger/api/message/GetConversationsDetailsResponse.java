package com.softgroup.messenger.api.message;


import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationMemberDTO;
import com.softgroup.messenger.api.dto.ConversationSettingsDTO;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:07
 */
public class GetConversationsDetailsResponse implements ResponseData {
    private List<ConversationMemberDTO> conversationMemberDTOs;

    public List<ConversationMemberDTO> getConversationMemberDTOs() {
        return conversationMemberDTOs;
    }

    public void setConversationMemberDTOs(List<ConversationMemberDTO> conversationMemberDTOs) {
        this.conversationMemberDTOs = conversationMemberDTOs;
    }
}
