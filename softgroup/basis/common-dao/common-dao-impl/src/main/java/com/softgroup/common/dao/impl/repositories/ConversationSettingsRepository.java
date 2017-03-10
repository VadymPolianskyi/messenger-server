package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationSettingsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:35
 */
public interface ConversationSettingsRepository extends PagingAndSortingRepository<ConversationSettingsEntity, String> {
}