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
import com.softgroup.messenger.api.message.DeleteConversationRequest;
import com.softgroup.messenger.api.message.DeleteConversationResponse;
import com.softgroup.messenger.impl.handler.DeleteConversationHandler;
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
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Author: vadym_polyanski
 * Date: 23.05.17
 * Time: 16:36
 */
@RunWith(MockitoJUnitRunner.class)
public class DeleteConversationHandlerTest {

    @InjectMocks
    private DeleteConversationHandler deleteConversationHandler;

    @Spy private ConversationService conversationService;
    @Spy private ConversationMemberService conversationMemberService;
    @Spy private ConversationSettingsService conversationSettingsService;
    @Spy private ResponseFactory<CreateConversationResponse> responseFactory;

    @Mock
    private Request<DeleteConversationRequest> request;

    private Response<DeleteConversationResponse> responseOk;
    private Response<DeleteConversationResponse> responseBadRequest;

    private final String CONVERSATION_ID = "conversationId";

    @Before
    public void init() {
        DeleteConversationRequest deleteConversationRequest = new DeleteConversationRequest();
        deleteConversationRequest.setConversationID(CONVERSATION_ID);

        when(request.getData()).thenReturn(deleteConversationRequest);

        ConversationEntity returnEntity = new ConversationEntity();
        returnEntity.setId("1");
        doNothing().when(conversationService).delete(CONVERSATION_ID);
        doNothing().when(conversationMemberService).deleteByConversationId(CONVERSATION_ID);
        doNothing().when(conversationSettingsService).deleteByConversationId(CONVERSATION_ID);


        doReturn(responseOk).when(responseFactory).createResponse(any(Request.class), any(CreateConversationResponse.class));
        doReturn(responseBadRequest).when(responseFactory).createResponse(any(Request.class), any(Status.class));
    }


    @Test
    public void testDoHandle() {
        assertThat(deleteConversationHandler.doHandle(request), is(responseOk));
    }

    @Test
    public void testBadRequest() {
        request.getData().setConversationID(null);
        assertThat(deleteConversationHandler.doHandle(request), is(responseBadRequest));
    }

    @Test(expected = NullPointerException.class)
    public void testNullableRequest() {
        request = null;
        Response<DeleteConversationResponse> response = deleteConversationHandler.doHandle(request);
    }

    @Test
    public void testName() {
        assertThat(deleteConversationHandler.getName(), is("delete_convesation"));
    }
}
