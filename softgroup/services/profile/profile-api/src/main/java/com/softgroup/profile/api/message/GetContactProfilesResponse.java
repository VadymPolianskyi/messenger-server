package com.softgroup.profile.api.message;


import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:09
 */
public class GetContactProfilesResponse implements ResponseData {
    private List<ProfileEntity> profileEntities;

    public List<ProfileEntity> getProfileEntities() {
        return profileEntities;
    }

    public void setProfileEntities(List<ProfileEntity> profileEntities) {
        this.profileEntities = profileEntities;
    }
}
