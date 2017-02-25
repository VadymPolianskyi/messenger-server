package com.softgroup.messenger.api.message.data;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:21
 */
public class Conversation {
    private ChatType chatType;
    private String uuid;
    private List<Message> listOfMessages;

    public List<Message> getListOfMessages() {
        return listOfMessages;
    }

    public void setListOfMessages(List<Message> listOfMessages) {
        this.listOfMessages = listOfMessages;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public ChatType getIsGroup() {
        return chatType;
    }

    public void setIsGroup(ChatType chatType) {
        this.chatType = chatType;
    }
}
