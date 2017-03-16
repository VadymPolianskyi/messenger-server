package com.softgroup.profile.api.message;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.protocol.RequestData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:13
 */
public class SetMyProfileRequest implements RequestData {

    private ProfileEntity profileEntity;

    public ProfileEntity getProfileEntities() {
        return profileEntity;
    }

    public void setProfileEntities(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

}
