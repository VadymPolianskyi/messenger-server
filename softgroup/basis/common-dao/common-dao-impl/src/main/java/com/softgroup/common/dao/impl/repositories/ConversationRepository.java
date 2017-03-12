package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:33
 */
public interface ConversationRepository extends PagingAndSortingRepository<ConversationEntity, String> {

}
