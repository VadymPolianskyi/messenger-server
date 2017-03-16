package com.softgroup.profile.api.message;


import com.softgroup.common.dao.api.entities.ProfileStatusEntity;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:24
 */
public class GetLastTimeOnlineResponse implements ResponseData {
    private List<ProfileStatusEntity> profileStatuses;

    public List<ProfileStatusEntity> getProfileStatuses() {
        return profileStatuses;
    }

    public void setProfileStatuses(List<ProfileStatusEntity> profileStatuses) {
        this.profileStatuses = profileStatuses;
    }
}
