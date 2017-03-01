package com.softgroup.db.repository;

import com.softgroup.db.entity.data.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 12:37
 */
public interface MessageCrudRepository extends CrudRepository<Message, UUID> {
    public List<Message> findAll();
}
