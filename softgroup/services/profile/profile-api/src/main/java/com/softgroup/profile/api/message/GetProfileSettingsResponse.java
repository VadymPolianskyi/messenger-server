package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ProfileSettingsDTO;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:18
 */
public class GetProfileSettingsResponse implements ResponseData {
    private ProfileSettingsDTO profileSettings;

    public ProfileSettingsDTO getProfileSettings() {
        return profileSettings;
    }

    public void setProfileSettings(ProfileSettingsDTO profileSettings) {
        this.profileSettings = profileSettings;
    }
}
