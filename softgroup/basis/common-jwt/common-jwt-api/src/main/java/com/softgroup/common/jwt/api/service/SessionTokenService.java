package com.softgroup.common.jwt.api.service;

/**
 * Author: vadym
 * Date: 17.03.17
 * Time: 17:14
 */
public interface SessionTokenService {
    void validateSessionToken(String token);
    String generateSessionToken(String profileID, String deviceID);
}
