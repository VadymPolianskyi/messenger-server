package com.softgroup.profile.api.message;

import com.softgroup.profile.api.message.data.Profile;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:11
 */
public class GetMyProfileResponse extends ProfileResponse {
    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    private List<Profile> profiles;
}
