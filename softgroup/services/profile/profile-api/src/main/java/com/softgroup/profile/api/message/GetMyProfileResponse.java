package com.softgroup.profile.api.message;


import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ProfileDTO;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:11
 */
public class GetMyProfileResponse implements ResponseData {
    private ProfileDTO profileDTO;

    public ProfileDTO getProfileDTO() {
        return profileDTO;
    }

    public void setProfileDTO(ProfileDTO profileDTO) {
        this.profileDTO = profileDTO;
    }
}
