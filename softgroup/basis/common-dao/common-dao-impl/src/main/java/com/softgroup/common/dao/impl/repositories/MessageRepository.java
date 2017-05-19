package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.MessageEntity;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:36
 */
public interface MessageRepository extends BaseRepository<MessageEntity> {

    List<MessageEntity> findByCreateDateGreaterThanAndConversationId(Long createDate, String conversationId);
}
