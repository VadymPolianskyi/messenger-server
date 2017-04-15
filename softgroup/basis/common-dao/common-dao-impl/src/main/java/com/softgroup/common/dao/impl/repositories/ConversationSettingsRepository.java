package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationSettingsEntity;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:35
 */
public interface ConversationSettingsRepository
        extends BaseRepository<ConversationSettingsEntity> {
    void deleteByConversationId(String conversationId);
    ConversationSettingsEntity findByConversationId(String conversationId);
    List<ConversationSettingsEntity> findByConversationIdIn(List<String> conversationIds);
}
