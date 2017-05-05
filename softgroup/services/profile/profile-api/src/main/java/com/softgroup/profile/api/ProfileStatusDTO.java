package com.softgroup.profile.api;

/**
 * Author: vadym_polyanski
 * Date: 14.04.17
 * Time: 15:21
 */
public class ProfileStatusDTO {

    public ProfileStatusDTO() {
    }

    public ProfileStatusDTO(String profileId, Long lastTimeOnline) {
        this.profileId = profileId;
        this.lastTimeOnline = lastTimeOnline;
    }

    private String profileId;

    private Boolean isOnline;

    private Long lastTimeOnline;



    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public Long getLastTimeOnline() {
        return lastTimeOnline;
    }

    public void setLastTimeOnline(Long lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
    }
}
