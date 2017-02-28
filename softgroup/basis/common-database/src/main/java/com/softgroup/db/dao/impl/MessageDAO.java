package com.softgroup.db.dao.impl;

import com.softgroup.db.dao.api.MessengerDAO;
import com.softgroup.db.dao.api.SessionManager;
import com.softgroup.db.entity.data.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 19:46
 */
public class MessageDAO implements MessengerDAO<Message, String> {

    @Autowired
    private SessionManager sessionManager;

    @Override
    public void update(Message message) {
        sessionManager.openCurrentSessionwithTransaction();
        sessionManager.getCurrentSession().update(message);
        sessionManager.closeCurrentSessionwithTransaction();
    }

    @Override
    public Message findById(String id) {
        sessionManager.openCurrentSession();
        Message message = (Message) sessionManager.getCurrentSession().get(Message.class, id);
        sessionManager.closeCurrentSession();
        return message;

    }

    @Override
    public void delete(Message message) {
        sessionManager.openCurrentSessionwithTransaction();
        sessionManager.getCurrentSession().delete(message);
        sessionManager.closeCurrentSessionwithTransaction();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Message> findAll() {
        sessionManager.openCurrentSession();
//        List<Message> messages = (List<Message>) sessionManager.getCurrentSession().createQuery("from MESSAGE").list();
        sessionManager.closeCurrentSession();
//        return messages;
        return null;
    }

    @Override
    public void deleteAll() {
        sessionManager.openCurrentSessionwithTransaction();
        List<Message> messages = findAll();
        for (Message message : messages) {
            delete(message);
        }
        sessionManager.closeCurrentSessionwithTransaction();
    }
}
