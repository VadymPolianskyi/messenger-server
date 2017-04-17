package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.impl.repositories.ConversationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:42
 */
@Component
public class ConversationService extends
        BaseService<ConversationEntity, ConversationRepository>{

    public List<ConversationEntity> findConversationsByIds(List<String> conversationIds) {
        return getRepository().findAll(conversationIds);
    }
        
    public List<ConversationEntity> findByTypeAndIdIn(ConversationType type, List<String> conversationIds) {
        return getRepository().findByTypeAndIdIn(type, conversationIds);
    }
}
