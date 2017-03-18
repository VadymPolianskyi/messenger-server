package com.softgroup.common.cache.entity;

/**
 * Author: vadym
 * Date: 18.03.17
 * Time: 18:14
 */
public class AuthorizationDetails implements CasheData {
    private String registrationRequestUuid;
    private String authCode;
    private String phoneNumber;
    private String localeCode;
    private String deviceId;

    public AuthorizationDetails(String registrationRequestUuid,
                                String authCode, String phoneNumber,
                                        String localeCode, String deviceId) {
        this.registrationRequestUuid = registrationRequestUuid;
        this.authCode = authCode;
        this.phoneNumber = phoneNumber;
        this.localeCode = localeCode;
        this.deviceId = deviceId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }


    public String getRegistrationRequestUuid() {
        return registrationRequestUuid;
    }

    public void setRegistrationRequestUuid(String registrationRequestUuid) {
        this.registrationRequestUuid = registrationRequestUuid;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
