package com.softgroup.db.repository;

import com.softgroup.db.entity.data.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 12:45
 */
public interface ContactCrudRepository extends CrudRepository<Contact, UUID> {
    public List<Contact> findAll();
}
