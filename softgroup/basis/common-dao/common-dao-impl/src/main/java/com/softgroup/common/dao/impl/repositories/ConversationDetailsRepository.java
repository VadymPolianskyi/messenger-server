package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationDetailsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:34
 */
public interface ConversationDetailsRepository extends PagingAndSortingRepository<ConversationDetailsEntity, String> {
}
