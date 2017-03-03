package com.softgroup.db.dao.impl;

import com.softgroup.db.dao.api.MessengerDAO;
import com.softgroup.db.entity.data.Conversation;
import com.softgroup.db.repository.ConversationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 19:49
 */
public class ConversationDAO implements MessengerDAO<Conversation, String>{
    @Autowired
    private ConversationCrudRepository conversationCrudRepository;

    @Override
    public void update(Conversation conversation) {
        conversationCrudRepository.save(conversation);
    }

    @Override
    public Conversation findById(String id) {
        Conversation conversation = conversationCrudRepository.findOne(UUID.fromString(id));
        return conversation;

    }

    @Override
    public void delete(Conversation conversation) {
        conversationCrudRepository.delete(conversation);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Conversation> findAll() {
        List<Conversation> conversations = conversationCrudRepository.findAll();
        return conversations;
    }

    @Override
    public void deleteAll() {
        List<Conversation> conversations = findAll();
        for (Conversation conversation : conversations) {
            delete(conversation);
        }
    }

    @Override
    public void insert(Conversation entity) {
        conversationCrudRepository.save(entity);
    }
}
