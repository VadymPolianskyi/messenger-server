package com.softgroup.common.jwt.test;

import com.softgroup.common.jwt.impl.service.TokenService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
/**
 * Created by vadym_polyanski on 28.03.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TokenServiceTest {

    @InjectMocks
    private TokenService tokenService;

    private String deviceToken;
    private String sessionToken;

    @Before
    public void init() {
        sessionToken = tokenService.generateSessionToken("profileId", "deviceId");
        deviceToken = tokenService.generateDeviceToken("profileId", "deviceId");
    }

    @Test
    public void testDeviceToken() throws InterruptedException {
        assertThat(tokenService.getDeviceID(deviceToken), is("deviceId"));
        assertThat(tokenService.getProfileID(deviceToken), is("profileId"));
    }

    @Test
    public void testSessionToken() throws InterruptedException {
        assertThat(tokenService.getDeviceID(sessionToken), is("deviceId"));
        assertThat(tokenService.getProfileID(sessionToken), is("profileId"));
    }

    @Primary
    @Test
    public void testNullable() {
        assertThat(deviceToken, notNullValue());
        assertThat(sessionToken, notNullValue());
    }

    @Test
    public void validateSessionToken() {
        tokenService.validateSessionToken(sessionToken);
    }

    @Test
    public void validateDeviceToken() {
        tokenService.validateDeviceToken(deviceToken);
    }

    @Test
    public void compareTokens() {
        assertThat(deviceToken, not(sessionToken));
    }
}
