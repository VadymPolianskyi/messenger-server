package com.softgroup.messenger.impl.test;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.impl.service.ConversationMemberService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseFactory;
import com.softgroup.common.protocol.Status;
import com.softgroup.messenger.api.dto.ConversationMemberDTO;
import com.softgroup.messenger.api.message.CreateConversationResponse;
import com.softgroup.messenger.api.message.GetConversationDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationDetailsResponse;
import com.softgroup.messenger.impl.handler.GetConversationDetailsHandler;
import com.softgroup.model.maper.Mapper;
import com.softgroup.profile.api.dto.ConversationDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Author: vadym_polyanski
 * Date: 26.05.17
 * Time: 21:12
 */
@RunWith(MockitoJUnitRunner.class)
public class GetConversationDetailsTest {
    @InjectMocks
    private GetConversationDetailsHandler getConversationDetailsHandler;

    @Spy private ConversationMemberService conversationMemberService;
    @Spy private Mapper<ConversationMemberEntity, ConversationMemberDTO> mapper;
    @Spy private ResponseFactory<CreateConversationResponse> responseFactory;

    @Mock
    private Request<GetConversationDetailsRequest> request;

    private Response<GetConversationDetailsResponse> responseOk;
    private Response<GetConversationDetailsResponse> responseNotFound;

    private final String CONVERSATION_ID = "conversationId";

    @Before
    public void init() {
        GetConversationDetailsRequest getConversationDetailsRequest = new GetConversationDetailsRequest();
        getConversationDetailsRequest.setConversationID(CONVERSATION_ID);

        when(request.getData()).thenReturn(getConversationDetailsRequest);

        doReturn(new ConversationMemberEntity()).when(conversationMemberService).findByConversationId(anyString());

        doReturn(new ConversationMemberDTO()).when(mapper).map(any(ConversationMemberEntity.class), any(Class.class));

        doReturn(responseOk).when(responseFactory).createResponse(any(Request.class), any(CreateConversationResponse.class));
        doReturn(responseNotFound).when(responseFactory).createResponse(any(Request.class), any(Status.class));
    }

    @Test
    public void testDoHandle() {
        assertThat(getConversationDetailsHandler.doHandle(request), is(responseOk));
    }

    @Test
    public void testBadRequest() {
        request.getData().setConversationID(null);
        assertThat(getConversationDetailsHandler.doHandle(request), is(responseNotFound));
    }

    @Test(expected = NullPointerException.class)
    public void testNullableRequest() {
        request = null;
        Response<GetConversationDetailsResponse> response = getConversationDetailsHandler.doHandle(request);
    }

    @Test
    public void testName() {
        assertThat(getConversationDetailsHandler.getName(), is("get_conversation_details"));
    }
}
