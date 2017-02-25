package com.softgroup.profile.api.message;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:21
 */
public class GetLastTimeOnlineRequest extends Command {
    public List<String> getProfilesUUID() {
        return profilesUUID;
    }

    public void setProfilesUUID(List<String> profilesUUID) {
        this.profilesUUID = profilesUUID;
    }

    private List<String> profilesUUID;
}
