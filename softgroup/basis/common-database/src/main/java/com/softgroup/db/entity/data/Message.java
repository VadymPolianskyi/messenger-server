package com.softgroup.db.entity.data;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:24
 */
public class Message {
    private int id;
    private Profile auhtor;
    private Conversation conversation;
    private Date localDate;
    private String messageBody;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getAuhtor() {
        return auhtor;
    }

    public void setAuhtor(Profile auhtor) {
        this.auhtor = auhtor;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }


}
