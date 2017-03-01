package com.softgroup.db.dao.impl;

import com.softgroup.db.dao.api.MessengerDAO;
import com.softgroup.db.entity.data.Contact;
import com.softgroup.db.repository.ContactCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 19:52
 */
public class ContactDAO implements MessengerDAO<Contact, String> {

    @Autowired
    private ContactCrudRepository contactCrudRepository;
    @Override
    public void update(Contact contact) {
        contactCrudRepository.save(contact);
    }

    @Override
    public Contact findById(String id) {
        Contact contact = contactCrudRepository.findOne(UUID.fromString(id));
        return contact;

    }

    @Override
    public void delete(Contact contact) {
        contactCrudRepository.delete(contact);
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = contactCrudRepository.findAll();
        return contacts;
    }

    @Override
    public void deleteAll() {
        List<Contact> contacts = findAll();
        for (Contact contact : contacts) {
            delete(contact);
        }
    }

    @Override
    public void insert(Contact entity) {
        contactCrudRepository.save(entity);
    }
}
