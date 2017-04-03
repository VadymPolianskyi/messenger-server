package com.softgroup.profile.api.message;


import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.protocol.ResponseData;
/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:11
 */
public class GetMyProfileResponse implements ResponseData {
    private ProfileEntity profileEntity;

    public ProfileEntity getProfileEntity() {
        return profileEntity;
    }

    public void setProfileEntity(ProfileEntity profileEntities) {
        this.profileEntity = profileEntity;
    }
}
