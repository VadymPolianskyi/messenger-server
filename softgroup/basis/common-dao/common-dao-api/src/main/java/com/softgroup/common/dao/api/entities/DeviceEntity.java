package com.softgroup.common.dao.api.entities;

import java.io.Serializable;

/**
 * Author: vadym
 * Date: 15.03.17
 * Time: 19:51
 */
public class DeviceEntity  implements Serializable {

    private static final long serialVersionUID = 7834796409815852123L;

    private String id;
    private ProfileEntity profileEntity;
    private String locale_code;
    private String deviceId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProfileEntity getProfileEntity() {
        return profileEntity;
    }

    public void setProfileEntity(ProfileEntity profileEntity) {
        this.profileEntity = profileEntity;
    }

    public String getLocale_code() {
        return locale_code;
    }

    public void setLocale_code(String locale_code) {
        this.locale_code = locale_code;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
