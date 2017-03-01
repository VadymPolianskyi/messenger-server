package com.softgroup.db.dao.impl;

import com.softgroup.db.dao.api.MessengerDAO;
import com.softgroup.db.entity.data.Message;
import com.softgroup.db.repository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 19:46
 */
public class MessageDAO implements MessengerDAO<Message, String> {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    @Override
    public void update(Message message) {
        messageCrudRepository.save(message);
    }

    @Override
    public Message findById(String id) {
        Message message = (Message) messageCrudRepository.findOne(UUID.fromString(id));
        return message;

    }

    @Override
    public void delete(Message message) {
        messageCrudRepository.delete(message);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Message> findAll() {
        List<Message> messages = messageCrudRepository.findAll();
        return messages;
    }

    @Override
    public void deleteAll() {
        List<Message> messages = findAll();
        for (Message message : messages) {
            delete(message);
        }
    }

    @Override
    public void insert(Message message) {
        messageCrudRepository.save(message);
    }
}
