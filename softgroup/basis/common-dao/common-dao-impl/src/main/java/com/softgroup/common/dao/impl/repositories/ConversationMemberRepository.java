package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationMemberEntity;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 14.04.17
 * Time: 16:01
 */
public interface ConversationMemberRepository extends BaseRepository<ConversationMemberEntity>{
    ConversationMemberEntity findByConversationId(String conversationId);
    void deleteByConversationId(String conversationId);
    List<ConversationMemberEntity> findByConversationIdIn(List<String> conversationIds);
    ConversationMemberEntity findByConversationIdAndProfileId(String conversationId, String profileId);
    List<ConversationMemberEntity> findByProfileId(String profileId);
}
