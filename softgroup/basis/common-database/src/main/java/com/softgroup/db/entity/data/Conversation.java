package com.softgroup.db.entity.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:21
 */
@Entity(name="conversation")
public class Conversation {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @ManyToMany()
    private List<Profile> participants;

    @OneToMany(mappedBy = "conversation")
    private List<Message> messages;

    @OneToOne()
    private ConversationDetails conversationDetails;

    @OneToOne()
    private ConversationSettings conversationSettings;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ConversationDetails getConversationDetails() {
        return conversationDetails;
    }

    public void setConversationDetails(ConversationDetails conversationDetails) {
        this.conversationDetails = conversationDetails;
    }

    public ConversationSettings getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(ConversationSettings conversationSettings) {
        this.conversationSettings = conversationSettings;
    }

    public List<Profile> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Profile> participants) {
        this.participants = participants;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
