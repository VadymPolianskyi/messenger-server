package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.dao.impl.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:43
 */
@Component
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<MessageEntity> findMessagesByConversation(ConversationEntity conversationEntity) {
        return messageRepository.findByConversationEntity(conversationEntity);
    }

    public List<MessageEntity> findMessagesByLocalDate(Date date) {
        return messageRepository.findByLocalDate(date);
    }
}
