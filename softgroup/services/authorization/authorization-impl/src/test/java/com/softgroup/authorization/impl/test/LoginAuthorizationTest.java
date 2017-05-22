package com.softgroup.authorization.impl.test;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.impl.handler.LoginAuthorizationHandler;
import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.impl.service.DeviceService;
import com.softgroup.common.jwt.impl.service.TokenService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.hamcrest.core.IsNull.notNullValue;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Author: vadym_polyanski
 * Date: 21.05.17
 * Time: 2:22
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginAuthorizationTest {
    @InjectMocks
    private LoginAuthorizationHandler loginAuthorizationHandler;

    @Spy
    private TokenService tokenService = new TokenService();

    @Spy
    private DeviceService deviceService;

    @Spy
    private ResponseFactory<LoginResponse> responseFactory = new ResponseFactory<>();

    @Mock
    private Request<LoginRequest> request;

    private String tokenStr;

    @Before
    public void init() {
        tokenStr = tokenService.generateDeviceToken("profileId", "deviceId");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setSessionToken(tokenStr);

        DeviceEntity deviceEntity = new DeviceEntity();

        when(request.getData()).thenReturn(loginRequest);
        doReturn(deviceEntity).when(deviceService).findDeviceEntityById("deviceId");
        doReturn(deviceEntity).when(deviceService).update(deviceEntity);

    }

    @Test
    public void testDoHandle() {
        assertThat(loginAuthorizationHandler.doHandle(request), notNullValue());
    }

    @Test
    public void testDetailResponce() {
        Response<LoginResponse> response = loginAuthorizationHandler.doHandle(request);
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getStatus().getMessage(), is("OK"));
        assertThat(response.getData().getToken(), notNullValue());
    }

    @Test
    public void testBadRequest() {
        request.getData().setSessionToken(null);
        Response<LoginResponse> response = loginAuthorizationHandler.doHandle(request);
        assertThat(response.getStatus().getCode(), is(400));
        assertThat(response.getStatus().getMessage(), is("BAD_REQUEST"));
    }

    @Test(expected = NullPointerException.class)
    public void testNullableRequest() {
        request = null;
        Response<LoginResponse> response = loginAuthorizationHandler.doHandle(request);
    }

    @Test
    public void testName() {
        assertThat(loginAuthorizationHandler.getName(), is("login"));
    }
}
