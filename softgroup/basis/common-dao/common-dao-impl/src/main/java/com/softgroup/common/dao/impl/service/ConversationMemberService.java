package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.impl.repositories.ConversationMemberRepository;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 14.04.17
 * Time: 16:01
 */
public class ConversationMemberService
        extends BaseService<ConversationMemberEntity, ConversationMemberRepository> {

    public void deleteByConversationId(String conversationId) {
        getRepository().deleteByConversationId(conversationId);
    }

    public ConversationMemberEntity findByConversationId(String conversationId) {
        return getRepository().findByConversationId(conversationId);
    }

    public List<ConversationMemberEntity> findByConversationIdIn(List<String> conversationIds) {
        return getRepository().findByConversationIdIn(conversationIds);
    }
        
    public List<ConversationMemberEntity> findByProfileId(String profileId) {
        return getRepository().findByProfileId(profileId);
    }

    public ConversationMemberEntity findByConversationIdAndProfileId(String conversationId, String profileId) {
        return getRepository().findByConversationIdAndProfileId(conversationId, profileId);
    }
}
