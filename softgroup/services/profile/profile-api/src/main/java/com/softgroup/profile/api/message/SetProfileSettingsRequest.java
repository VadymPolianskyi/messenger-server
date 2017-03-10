package com.softgroup.profile.api.message;

import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.protocol.RequestData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:20
 */
public class SetProfileSettingsRequest implements RequestData {
    private ProfileSettingsEntity profileSettingsEntity;

    public ProfileSettingsEntity getProfileSettingsEntity() {
        return profileSettingsEntity;
    }

    public void setProfileSettingsEntity(ProfileSettingsEntity profileSettingsEntity) {
        this.profileSettingsEntity = profileSettingsEntity;
    }
}
