package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.types.ConversationType;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:33
 */
public interface ConversationRepository extends BaseRepository<ConversationEntity> {
    List<ConversationEntity> findByTypeAndIdIn(ConversationType type, List<String> conversationIds);
}
