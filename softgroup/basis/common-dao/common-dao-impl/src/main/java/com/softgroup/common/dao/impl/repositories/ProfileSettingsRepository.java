package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;

import java.util.List;


/**
 * Author: vadym
 * Date: 05.03.17
 * Time: 10:24
 */
public interface ProfileSettingsRepository extends BaseRepository<ProfileSettingsEntity> {
    List<ProfileSettingsEntity> findAll();
}
