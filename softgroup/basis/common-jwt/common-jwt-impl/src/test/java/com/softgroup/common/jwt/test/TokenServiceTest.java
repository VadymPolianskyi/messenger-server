package com.softgroup.common.jwt.test;

import com.softgroup.common.jwt.impl.service.TokenService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
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

    @Test
    public void testDeviceToken() throws InterruptedException {
        testCreatingToken();
        assertThat(tokenService.getDeviceID(deviceToken), is("deviceId"));
        assertThat(tokenService.getProfileID(deviceToken), is("profileId"));

        Thread.sleep(1000);
        assertThat(tokenService.generateDeviceToken("profileId", "deviceId"),
                not(deviceToken));
    }

    @Test
    public void testSessionToken() throws InterruptedException {
        testCreatingToken();
        assertThat(tokenService.getDeviceID(sessionToken), is("deviceId"));
        assertThat(tokenService.getProfileID(sessionToken), is("profileId"));

        Thread.sleep(1000);
        assertThat(tokenService.generateSessionToken("profileId", "deviceId"),
                not(sessionToken));
    }

    @Primary
    @Test
    public void testCreatingToken() {
        sessionToken = tokenService.generateSessionToken("profileId", "deviceId");
        deviceToken = tokenService.generateDeviceToken("profileId", "deviceId");

        assertThat(deviceToken, notNullValue());
        assertThat(sessionToken, notNullValue());
        assertThat(deviceToken, not(sessionToken));
    }
}
