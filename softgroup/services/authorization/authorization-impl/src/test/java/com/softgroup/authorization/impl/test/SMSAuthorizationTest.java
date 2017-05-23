package com.softgroup.authorization.impl.test;

import com.softgroup.authorization.api.message.SMSRequest;
import com.softgroup.authorization.api.message.SMSResponse;
import com.softgroup.authorization.impl.handler.SMSAuthorizationHandler;
import com.softgroup.authorization.impl.handler.key.KeysGenerator;
import com.softgroup.common.cache.entity.AuthorizationDetails;
import com.softgroup.common.cache.service.AuthorizationDetailsCacheService;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.service.ProfileService;
import com.softgroup.common.protocol.Status;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.impl.service.DeviceService;
import com.softgroup.common.jwt.impl.service.TokenService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;
/**
 * Author: vadym_polyanski
 * Date: 21.05.17
 * Time: 21:42
 */
@RunWith(MockitoJUnitRunner.class)
public class SMSAuthorizationTest {
    @InjectMocks
    private SMSAuthorizationHandler smsAuthorizationHandler;

    @Spy private TokenService tokenService;
    @Spy private ProfileService profileService;
    @Spy private DeviceService deviceService;
    @Spy private AuthorizationDetailsCacheService authorizationDetailsCacheService;
    @Spy private ResponseFactory<SMSResponse> responseFactory;

    private String authCode;
    private String registrationRequestUuid;

    private final String BAD_UUID = "BadUUID";
    private final String TOKEN_STR = "SOME_TOKEN_STR";

    @Mock
    private Request<SMSRequest> request;

    private Response<SMSRequest> responseOk;
    private Response<SMSRequest> responseNotFound;

    @Before
    public void init() throws ExecutionException {
        KeysGenerator keysGenerator = new KeysGenerator();
        registrationRequestUuid = keysGenerator.generateKey();
        authCode = keysGenerator.generateKey();

        SMSRequest smsRequest = new SMSRequest();
        smsRequest.setAuthCode(authCode);
        smsRequest.setRegistrationRequestUuid(registrationRequestUuid);

        when(request.getData()).thenReturn(smsRequest);

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId("profileId");
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setId("deviceId");
        AuthorizationDetails authorizationDetails = new AuthorizationDetails(registrationRequestUuid, authCode,
                "00000000","UA", "deviceId", "profile");

        doReturn(authorizationDetails).when(authorizationDetailsCacheService).getFromCache(registrationRequestUuid);
        doReturn(authorizationDetails).when(authorizationDetailsCacheService).getFromCache(BAD_UUID);

        doReturn(TOKEN_STR).when(tokenService).generateSessionToken(anyString(), anyString());

        doReturn(deviceEntity).when(deviceService).save(any(DeviceEntity.class));
        doReturn(profileEntity).when(profileService).save(any(ProfileEntity.class));

        doReturn(responseOk).when(responseFactory).createResponse(any(Request.class), any(SMSResponse.class));
        doReturn(responseNotFound).when(responseFactory).createResponse(any(Request.class), any(Status.class));
    }

    @Test
    public void testDoHandle() {
        assertThat(smsAuthorizationHandler.doHandle(request), is(responseOk));
    }

    @Test
    public void testBadRequest() {
        request.getData().setRegistrationRequestUuid(BAD_UUID);
        assertThat(smsAuthorizationHandler.doHandle(request), is(responseNotFound));
    }

    @Test(expected = NullPointerException.class)
    public void testNullableRequest() {
        request = null;
        Response<SMSResponse> response = smsAuthorizationHandler.doHandle(request);
    }

    @Test
    public void testName() {
        assertThat(smsAuthorizationHandler.getName(), is("sms_confirm"));
    }
}