package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ProfileEntity;


/**
 * Author: vadym
 * Date: 05.03.17
 * Time: 10:24
 */
public interface ProfileRepository extends BaseRepository<ProfileEntity> {



    ProfileEntity findByPhoneNumber(String phoneNumber);

    ProfileEntity findById(String id);
}
