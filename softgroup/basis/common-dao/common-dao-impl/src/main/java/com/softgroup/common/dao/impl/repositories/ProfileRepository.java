package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ProfileEntity;

import java.util.List;


/**
 * Author: vadym
 * Date: 05.03.17
 * Time: 10:24
 */
public interface ProfileRepository extends BaseRepository<ProfileEntity> {

    List<ProfileEntity> findByFirstName(String firstName);

    List<ProfileEntity> findByFirstNameAndPhoneNumber(String firstName, String phoneNumber);

    ProfileEntity findByLocaleCode(String localeCode);

    ProfileEntity findByDeviceId(String deviceId);

    ProfileEntity findByPhoneNumber(String phoneNumber);

    ProfileEntity findById(String id);
}
