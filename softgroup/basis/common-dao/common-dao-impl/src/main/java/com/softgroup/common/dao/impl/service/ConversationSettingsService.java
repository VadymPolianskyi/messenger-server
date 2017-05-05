package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.ConversationSettingsEntity;
import com.softgroup.common.dao.impl.repositories.ConversationSettingsRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:42
 */
@Component
public class ConversationSettingsService
        extends  BaseService<ConversationSettingsEntity, ConversationSettingsRepository>{
    public void deleteByConversationId(String conversationId) {
        getRepository().deleteByConversationId(conversationId);
    }

    public ConversationSettingsEntity findByConversationId(String conversationId) {
        return getRepository().findByConversationId(conversationId);
    }

    public List<ConversationSettingsEntity> findByConversationIdIn(List<String> conversationIds) {
        return getRepository().findByConversationIdIn(conversationIds);
    }
        
    public ConversationSettingsEntity findByAdminId(String profileId) {
        return getRepository().findByAdminId(profileId);
    }
}
