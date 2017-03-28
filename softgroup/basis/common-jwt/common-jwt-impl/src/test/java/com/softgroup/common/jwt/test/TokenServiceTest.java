package com.softgroup.common.jwt.test;

import com.softgroup.common.jwt.impl.service.TokenService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

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
        deviceToken = tokenService.generateDeviceToken("profileId", "deviceId");
        sessionToken = tokenService.generateSessionToken("profileId", "deviceId");
    }

    @Test
    public void testDeviceToken() throws InterruptedException {
        assertThat(deviceToken, not(sessionToken));

        assertThat(tokenService.getDeviceID(deviceToken), is("deviceId"));
        assertThat(tokenService.getProfileID(deviceToken), is("profileId"));

        Thread.sleep(1000);
        assertThat(tokenService.generateDeviceToken("profileId", "deviceId"),
                not(deviceToken));
    }

    @Test
    public void testSessionToken() throws InterruptedException {
        assertThat(tokenService.getDeviceID(sessionToken), is("deviceId"));
        assertThat(tokenService.getProfileID(sessionToken), is("profileId"));

        Thread.sleep(1000);
        assertThat(tokenService.generateSessionToken("profileId", "deviceId"),
                not(sessionToken));


    }
}
