package com.softgroup.profile.api.message;


import com.softgroup.common.protocol.ResponseData;
import com.softgroup.profile.api.dto.ProfileDTO;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:16
 */
public class GetOtherProfilesResponse implements ResponseData {
    private List<ProfileDTO> profileDTOS;

    public List<ProfileDTO> getProfileDTOS() {
        return profileDTOS;
    }

    public void setProfileDTOS(List<ProfileDTO> profileDTOS) {
        this.profileDTOS = profileDTOS;
    }
}
