package com.softgroup.profile.api.message;

import com.softgroup.db.entity.data.Profile;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:16
 */
public class GetOtherProfilesResponse extends ProfileResponse {
    private List<Profile> profiles;

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}
