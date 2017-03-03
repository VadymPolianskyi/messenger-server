package com.softgroup.profile.api.message;

import com.softgroup.db.entity.data.ProfileSettings;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:18
 */
public class GetProfileSettingsResponse extends ProfileResponse {
    public List<ProfileSettings> getSettings() {
        return settings;
    }

    public void setSettings(List<ProfileSettings> settings) {
        this.settings = settings;
    }

    private List<ProfileSettings> settings;
}
