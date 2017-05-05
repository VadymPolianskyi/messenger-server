package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ContactEntity;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:32
 */
public interface ContactRepository extends BaseRepository<ContactEntity> {


    ContactEntity findByNameAndProfileIdAndPhoneNumber();

    List<ContactEntity> findByProfileId(String profileId);
}
