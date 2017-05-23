package com.softgroup.messenger.impl.test;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.api.entities.ConversationSettingsEntity;
import com.softgroup.common.dao.api.entities.types.ConversationType;
import com.softgroup.common.dao.impl.service.ConversationMemberService;
import com.softgroup.common.dao.impl.service.ConversationService;
import com.softgroup.common.dao.impl.service.ConversationSettingsService;
import com.softgroup.common.protocol.*;
import com.softgroup.messenger.api.message.CreateConversationRequest;
import com.softgroup.messenger.api.message.CreateConversationResponse;
import com.softgroup.messenger.impl.handler.CreateConversationHandler;
import com.softgroup.model.maper.Mapper;
import com.softgroup.profile.api.dto.ConversationDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Author: vadym_polyanski
 * Date: 23.05.17
 * Time: 16:36
 */
@RunWith(MockitoJUnitRunner.class)
public class CreateConversationHandlerTest {

    @InjectMocks
    private CreateConversationHandler createConversationHandler;

    @Spy private ConversationService conversationService;
    @Spy private ConversationMemberService conversationMemberService;
    @Spy private ConversationSettingsService conversationSettingsService;
    @Spy private Mapper<ConversationEntity, ConversationDTO> mapper;
    @Spy private ResponseFactory<CreateConversationResponse> responseFactory;

    @Mock
    private Request<CreateConversationRequest> request;

    private Response<CreateConversationResponse> responseOk;
    private Response<CreateConversationResponse> responseBadRequest;

    @Before
    public void init() {
        CreateConversationRequest createConversationRequest = new CreateConversationRequest();
        createConversationRequest.setMembersIDs(Arrays.asList("fir", "sec", "thir"));
        createConversationRequest.setType(ConversationType.CONVERSATION);

        when(request.getData()).thenReturn(createConversationRequest);
        when(request.getRoutingData()).thenReturn(new RoutingData("profileId", "deviceId"));

        ConversationEntity returnEntity = new ConversationEntity();
        returnEntity.setId("1");
        doReturn(returnEntity).when(conversationService).save(any(ConversationEntity.class));
        doReturn(new ConversationMemberEntity()).when(conversationMemberService).save(any(ConversationMemberEntity.class));
        doReturn(new ConversationSettingsEntity()).when(conversationSettingsService).save(any(ConversationSettingsEntity.class));

        doReturn(new ConversationDTO()).when(mapper).map(any(ConversationEntity.class), any(Class.class));

        doReturn(responseOk).when(responseFactory).createResponse(any(Request.class), any(CreateConversationResponse.class));
        doReturn(responseBadRequest).when(responseFactory).createResponse(any(Request.class), any(Status.class));
    }


    @Test
    public void testDoHandle() {
        assertThat(createConversationHandler.doHandle(request), is(responseOk));
    }

    @Test
    public void testBadRequest() {
        request.getData().setType(null);
        assertThat(createConversationHandler.doHandle(request), is(responseBadRequest));
    }

    @Test(expected = NullPointerException.class)
    public void testNullableRequest() {
        request = null;
        Response<CreateConversationResponse> response = createConversationHandler.doHandle(request);
    }

    @Test
    public void testName() {
        assertThat(createConversationHandler.getName(), is("create_conversation"));
    }
}
