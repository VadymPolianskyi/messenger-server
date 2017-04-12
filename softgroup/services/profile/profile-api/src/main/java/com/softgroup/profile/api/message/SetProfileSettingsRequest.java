package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.profile.api.dto.ProfileSettingsDTO;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:20
 */
public class SetProfileSettingsRequest implements RequestData {
    private ProfileSettingsDTO profileSettings;

    public ProfileSettingsDTO getProfileSettings() {
        return profileSettings;
    }

    public void setProfileSettings(ProfileSettingsDTO profileSettings) {
        this.profileSettings = profileSettings;
    }
}
