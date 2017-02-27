package com.softgroup.profile.api.message;

import com.softgroup.db.entity.data.ProfileSettings;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:20
 */
public class SetProfileSettingsRequest extends ProfileRequest {
    private ProfileSettings profileSettings;

    public ProfileSettings getProfileSettings() {
        return profileSettings;
    }

    public void setProfileSettings(ProfileSettings profileSettings) {
        this.profileSettings = profileSettings;
    }
}
