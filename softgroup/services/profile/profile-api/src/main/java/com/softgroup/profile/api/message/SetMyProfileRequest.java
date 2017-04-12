package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.profile.api.dto.ProfileDTO;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:13
 */
public class SetMyProfileRequest implements RequestData {

    private ProfileDTO profile;

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }
}
