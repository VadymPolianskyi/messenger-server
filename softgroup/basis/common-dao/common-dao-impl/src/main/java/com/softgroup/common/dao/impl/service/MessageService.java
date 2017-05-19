package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.dao.impl.repositories.MessageRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:43
 */
@Component
public class MessageService extends BaseService<MessageEntity, MessageRepository> {

    public List<MessageEntity> findByCreateDateGreaterThanAndConversationId(Long createDate, String conversationId) {
        return getRepository().findByCreateDateGreaterThanAndConversationId(createDate, conversationId);
    }

}
