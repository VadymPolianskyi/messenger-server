package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ContactEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:32
 */
public interface ContactRepository extends PagingAndSortingRepository<ContactEntity, String> {

}
