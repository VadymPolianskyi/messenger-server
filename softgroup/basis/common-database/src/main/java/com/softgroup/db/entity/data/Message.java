package com.softgroup.db.entity.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:24
 */
@Entity(name = "message")
public class Message {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String  id;

    @ManyToOne(targetEntity = Profile.class)
    private Profile auhtor;

    @ManyToOne(targetEntity = Conversation.class)
    private Conversation conversation;


    private Date localDate;
    private String messageBody;

    public String getId() {
        return id;
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
