package com.softgroup.profile.api.message;


import com.softgroup.common.protocol.ResponseData;
import com.softgroup.model.maper.ProfileDTO;
import com.softgroup.profile.api.ProfileStatusDTO;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:24
 */
public class GetLastTimeOnlineResponse implements ResponseData {
    private List<ProfileStatusDTO> profileStatusDTOS;

    public List<ProfileStatusDTO> getProfileStatusDTOS() {
        return profileStatusDTOS;
    }

    public void setProfileStatusDTOS(List<ProfileStatusDTO> profileStatusDTOS) {
        this.profileStatusDTOS = profileStatusDTOS;
    }
}
