package com.softgroup.common.protocol;

/**
 * Created by vadym_polyanski on 22.03.17.
 */
public class RoutingData {

    private String profileId;

    private String deviceId;


    public RoutingData(String profileId, String deviceId) {
        this.profileId = profileId;
        this.deviceId = deviceId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
