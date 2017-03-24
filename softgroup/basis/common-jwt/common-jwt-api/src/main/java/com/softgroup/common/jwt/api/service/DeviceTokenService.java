package com.softgroup.common.jwt.api.service;

/**
 * Author: vadym
 * Date: 17.03.17
 * Time: 17:02
 */
public interface DeviceTokenService {
    void validateDeviceToken(String token);
    String generateDeviceToken(String profileID, String deviceID);
}
