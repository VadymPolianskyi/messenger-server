package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.MessageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:36
 */
public interface MessageRepository extends PagingAndSortingRepository<MessageEntity, String> {

    List<MessageEntity> findByConversationEntity(ConversationEntity conversationEntity);

    List<MessageEntity> findByLocalDate(Date date);
}
