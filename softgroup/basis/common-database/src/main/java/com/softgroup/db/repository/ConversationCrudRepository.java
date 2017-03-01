package com.softgroup.db.repository;

import com.softgroup.db.entity.data.Conversation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 12:41
 */
public interface ConversationCrudRepository extends CrudRepository<Conversation, UUID> {
    public List<Conversation> findAll();
}
