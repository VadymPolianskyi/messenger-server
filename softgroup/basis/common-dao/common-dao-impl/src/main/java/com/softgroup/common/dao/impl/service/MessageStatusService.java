package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.MessageStatusEntity;
import com.softgroup.common.dao.impl.repositories.MessageStatusRepository;

/**
 * Author: vadym_polyanski
 * Date: 30.03.17
 * Time: 16:58
 */
public class MessageStatusService extends BaseService<MessageStatusEntity, MessageStatusRepository> {
    public MessageStatusEntity findByMessageId(String messageId) {
        return getRepository().findByMessageId(messageId);
    }
}
