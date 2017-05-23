package com.softgroup.authorization.impl.test;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.impl.handler.LoginAuthorizationHandler;
import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.impl.service.DeviceService;
import com.softgroup.common.jwt.impl.service.TokenService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseFactory;
import com.softgroup.common.protocol.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
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

    @Spy private TokenService tokenService;
    @Spy private DeviceService deviceService;
    @Spy private ResponseFactory<LoginResponse> responseFactory;

    @Mock
    private Request<LoginRequest> request;

    private Response<RegisterResponse> responseOk;
    private Response<RegisterResponse> responseBadRequest;

    private final String TOKEN_STR = "SOME_TOKEN_STR";
    private final String DEVICE_ID = "SOME_TOKEN_STR";
    private final String PROFILE_ID = "SOME_TOKEN_STR";

    @Before
    public void init() {
        doReturn(PROFILE_ID).when(tokenService).getProfileID(TOKEN_STR);
        doReturn(DEVICE_ID).when(tokenService).getDeviceID(TOKEN_STR);
        doReturn(1L).when(tokenService).getTimeOfCreation(TOKEN_STR);
        doReturn(TOKEN_STR).when(tokenService).generateDeviceToken(anyString(), anyString());


        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setSessionToken(TOKEN_STR);

        DeviceEntity deviceEntity = new DeviceEntity();

        when(request.getData()).thenReturn(loginRequest);
        doReturn(deviceEntity).when(deviceService).findDeviceEntityById(DEVICE_ID);
        doReturn(deviceEntity).when(deviceService).update(deviceEntity);

        doReturn(responseOk).when(responseFactory).createResponse(any(Request.class), any(LoginResponse.class));
        doReturn(responseBadRequest).when(responseFactory).createResponse(any(Request.class), any(Status.class));

    }

    @Test
    public void testDoHandle() {
        assertThat(loginAuthorizationHandler.doHandle(request), is(responseOk));
    }



    @Test
    public void testBadRequest() {
        request.getData().setSessionToken(null);
        assertThat(loginAuthorizationHandler.doHandle(request), is(responseBadRequest));
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
