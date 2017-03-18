package com.softgroup.common.jwt.api.service;

/**
 * Author: vadym
 * Date: 17.03.17
 * Time: 17:01
 */
public interface UniversalTokenService extends DeviceTokenService, SessionTokenService {
    Long getTimeOfCreation(String token);
    TokenType getTokenType(String token);
    String getDeviceID(String token);
    String getProfileID(String token);
}
