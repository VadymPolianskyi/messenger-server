package com.softgroup.profile.api.message;

import com.softgroup.profile.api.message.data.ProfileStatus;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:24
 */
public class GetLastTimeOnlineResponse extends Command {
    private List<ProfileStatus> profileStatuses;

    public List<ProfileStatus> getProfileStatuses() {
        return profileStatuses;
    }

    public void setProfileStatuses(List<ProfileStatus> profileStatuses) {
        this.profileStatuses = profileStatuses;
    }
}
