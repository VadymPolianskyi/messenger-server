package com.softgroup.db.dao.impl;

import com.softgroup.db.dao.api.MessengerDAO;
import com.softgroup.db.dao.api.SessionManager;
import com.softgroup.db.entity.data.Contact;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 19:52
 */
public class ContactDAO implements MessengerDAO<Contact, String> {

    @Autowired
    private SessionManager sessionManager;

    @Override
    public void update(Contact contact) {
        sessionManager.openCurrentSessionwithTransaction();
        sessionManager.getCurrentSession().update(contact);
        sessionManager.closeCurrentSessionwithTransaction();
    }

    @Override
    public Contact findById(String id) {
        sessionManager.openCurrentSession();
        Contact contact = (Contact) sessionManager.getCurrentSession().get(Contact.class, id);
        sessionManager.closeCurrentSession();
        return contact;

    }

    @Override
    public void delete(Contact contact) {
        sessionManager.openCurrentSessionwithTransaction();
        sessionManager.getCurrentSession().delete(contact);
        sessionManager.closeCurrentSessionwithTransaction();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> findAll() {
        sessionManager.openCurrentSession();
//        List<Contact> contacts = (List<Contact>) sessionManager.getCurrentSession().createQuery("from CONTACT").list();
        sessionManager.closeCurrentSession();
//        return contacts;
        return null;
    }

    @Override
    public void deleteAll() {
        sessionManager.openCurrentSessionwithTransaction();
        List<Contact> contacts = findAll();
        for (Contact contact : contacts) {
            delete(contact);
        }
        sessionManager.closeCurrentSessionwithTransaction();
    }
}
