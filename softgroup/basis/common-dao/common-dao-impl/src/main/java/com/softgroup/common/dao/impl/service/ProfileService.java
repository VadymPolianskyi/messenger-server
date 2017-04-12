package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:40
 */
@Component
public class ProfileService extends BaseService<ProfileEntity, ProfileRepository> {
    @Autowired
    ProfileRepository profileRepository;

    public ProfileEntity findProfileById(String id) {
        return  getRepository().findById(id);
    }

    public List<ProfileEntity> findByArrayOfIds(List<String> uuids) {
        return getRepository().findByArrayOfIds(uuids);
    }
}
