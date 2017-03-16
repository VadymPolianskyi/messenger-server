package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ProfileStatusEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:36
 */
public interface ProfileStatusRepository extends PagingAndSortingRepository<ProfileStatusEntity, String> {
}
