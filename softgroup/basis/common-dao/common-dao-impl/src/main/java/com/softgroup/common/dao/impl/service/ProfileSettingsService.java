package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.dao.impl.repositories.ProfileSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:44
 */
@Component
public class ProfileSettingsService {
    @Autowired
    ProfileSettingsRepository profileSettingsRepository;

    public void deleteSetting(String id) {
        profileSettingsRepository.delete(id);
    }

    public void deleteSettings(List<ProfileSettingsEntity> settingsEntities) {
        for (ProfileSettingsEntity settingsEntity : settingsEntities) {
            profileSettingsRepository.delete(settingsEntity.getId());
        }

    }
}
