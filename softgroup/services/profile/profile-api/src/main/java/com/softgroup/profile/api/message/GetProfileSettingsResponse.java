package com.softgroup.profile.api.message;

import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:18
 */
public class GetProfileSettingsResponse implements ResponseData {
    public ProfileSettingsEntity getSettings() {
        return settings;
    }

    public void setSettings(ProfileSettingsEntity settings) {
        this.settings = settings;
    }

    private ProfileSettingsEntity settings;
}
