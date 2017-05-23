package com.softgroup.authorization.impl.test;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.impl.handler.RegisterAuthorizationHandler;
import com.softgroup.authorization.impl.handler.key.KeysGenerator;
import com.softgroup.common.cache.entity.AuthorizationDetails;
import com.softgroup.common.cache.service.AuthorizationDetailsCacheService;
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
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Author: vadym_polyanski
 * Date: 21.05.17
 * Time: 21:42
 */
@RunWith(MockitoJUnitRunner.class)
public class RegisterAuthorizationTest {
    @InjectMocks
    private RegisterAuthorizationHandler registerAuthorizationHandler;

    @Spy private AuthorizationDetailsCacheService authorizationDetailsCacheService;
    @Spy private ResponseFactory<RegisterResponse> responseFactory;
    @Spy private KeysGenerator keysGenerator;

    private final String BAD_UUID = "BadUUID";
    private final String KEY_FROM_GENERATOR = "KEY";

    @Mock
    private Request<RegisterRequest> request;

    private Response<RegisterResponse> responseOk;
    private Response<RegisterResponse> responseBadRequest;

    @Before
    public void init() throws ExecutionException {



        RegisterRequest registerRequest = new RegisterRequest();
        String defaultStr = "def";
        registerRequest.setName(defaultStr);
        registerRequest.setDeviceId(defaultStr);
        registerRequest.setLocaleCode(defaultStr);
        registerRequest.setPhoneNumber(defaultStr);

        when(request.getData()).thenReturn(registerRequest);

        String registrationRequestUuid = keysGenerator.generateKey();
        String authCode = keysGenerator.generateKey();
        AuthorizationDetails authorizationDetails = new AuthorizationDetails(registrationRequestUuid, authCode,
                "00000000","UA", "deviceId", "profile");

        doNothing().when(authorizationDetailsCacheService).put(any(AuthorizationDetails.class));

        doReturn(KEY_FROM_GENERATOR).when(keysGenerator).generateKey();

        doReturn(responseOk).when(responseFactory).createResponse(any(Request.class), any(RegisterResponse.class));
        doReturn(responseBadRequest).when(responseFactory).createResponse(any(Request.class), any(Status.class));
    }

    @Test
    public void testDoHandle() {
        assertThat(registerAuthorizationHandler.doHandle(request), is(responseOk));
    }

    @Test
    public void testBadRequest() {
        request.getData().setName(null);
        assertThat(registerAuthorizationHandler.doHandle(request), is(responseBadRequest));
    }

    @Test(expected = NullPointerException.class)
    public void testNullableRequest() {
        request = null;
        Response<RegisterResponse> response = registerAuthorizationHandler.doHandle(request);
    }

    @Test
    public void testName() {
        assertThat(registerAuthorizationHandler.getName(), is("register"));
    }
}