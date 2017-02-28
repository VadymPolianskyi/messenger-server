package com.softgroup.db.entity.data;

import java.util.Date;
import java.util.List;

/**
 * Author: vadym
 * Date: 27.02.17
 * Time: 21:02
 */
public class ConversationDetails {
    private Conversation conversation;
    private Date dateOfCreation;
    private String title;
    private List<Message> listOfMessages;
    private Message cursor;

    public List<Message> getListOfMessages() {
        return listOfMessages;
    }

    public void setListOfMessages(List<Message> listOfMessages) {
        this.listOfMessages = listOfMessages;
    }

}
