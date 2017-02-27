package com.softgroup.db.entity.data;

import java.util.List;

/**
 * Author: vadym
 * Date: 27.02.17
 * Time: 21:02
 */
public class ConversationSettings {
    private Conversation conversation;
    private List<Profile> participants;

    public List<Profile> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Profile> participants) {
        this.participants = participants;
    }
}
