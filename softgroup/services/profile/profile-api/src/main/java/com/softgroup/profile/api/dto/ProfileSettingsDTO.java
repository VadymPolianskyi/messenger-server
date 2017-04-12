package com.softgroup.profile.api.dto;

/**
 * Author: vadym_polyanski
 * Date: 08.04.17
 * Time: 22:38
 */
public class ProfileSettingsDTO {
    private String settingsData;

    private String profileId;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getSettingsData() {
        return settingsData;
    }

    public void setSettingsData(String settingsData) {
        this.settingsData = settingsData;
    }
}
