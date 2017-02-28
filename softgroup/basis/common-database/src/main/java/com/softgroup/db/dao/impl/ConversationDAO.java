package com.softgroup.db.dao.impl;

import com.softgroup.db.dao.api.MessengerDAO;
import com.softgroup.db.dao.api.SessionManager;
import com.softgroup.db.entity.data.Conversation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 19:49
 */
public class ConversationDAO implements MessengerDAO<Conversation, String>{
    @Autowired
    private SessionManager sessionManager;

    @Override
    public void update(Conversation conversation) {
        sessionManager.openCurrentSessionwithTransaction();
        sessionManager.getCurrentSession().update(conversation);
        sessionManager.closeCurrentSessionwithTransaction();
    }

    @Override
    public Conversation findById(String id) {
        sessionManager.openCurrentSession();
        Conversation conversation = (Conversation) sessionManager.getCurrentSession().get(Conversation.class, id);
        sessionManager.closeCurrentSession();
        return conversation;

    }

    @Override
    public void delete(Conversation conversation) {
        sessionManager.openCurrentSessionwithTransaction();
        sessionManager.getCurrentSession().delete(conversation);
        sessionManager.closeCurrentSessionwithTransaction();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Conversation> findAll() {
        sessionManager.openCurrentSession();
//        List<Conversation> conversations = (List<Conversation>) sessionManager.getCurrentSession().createQuery("from CONVERSATION").list();
        sessionManager.closeCurrentSession();
//        return conversations;
        return null;
    }

    @Override
    public void deleteAll() {
        sessionManager.openCurrentSessionwithTransaction();
        List<Conversation> conversations = findAll();
        for (Conversation conversation : conversations) {
            delete(conversation);
        }
        sessionManager.closeCurrentSessionwithTransaction();
    }
}
