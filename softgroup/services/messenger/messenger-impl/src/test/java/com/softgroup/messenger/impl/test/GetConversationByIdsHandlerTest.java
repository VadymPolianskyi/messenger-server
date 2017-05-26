package com.softgroup.messenger.impl.test;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.impl.service.ConversationService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseFactory;
import com.softgroup.common.protocol.Status;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.impl.handler.GetConversationByIdsHandler;
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
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Author: vadym_polyanski
 * Date: 23.05.17
 * Time: 16:36
 */
@RunWith(MockitoJUnitRunner.class)
public class GetConversationByIdsHandlerTest {

    @InjectMocks
    private GetConversationByIdsHandler getConversationByIdsHandler;

    @Spy private ConversationService conversationService;
    @Spy private ResponseFactory<CreateConversationResponse> responseFactory;
    @Spy private Mapper<ConversationEntity, ConversationDTO> mapper;

    @Mock
    private Request<GetConversationByIdsRequest> request;

    private Response<GetConversationByIdsResponse> responseOk;
    private Response<GetConversationByIdsResponse> responseNotFound;

    @Before
    public void init() {
        GetConversationByIdsRequest getConversationByIdsRequest = new GetConversationByIdsRequest();
        getConversationByIdsRequest.setConversationIDs(Arrays.asList("firstId", "secondId"));

        when(request.getData()).thenReturn(getConversationByIdsRequest);

        doReturn(Arrays.asList(new ConversationEntity(), new ConversationEntity()))
                .when(conversationService).findConversationsByIds(any(List.class));

        doReturn(new ConversationDTO()).when(mapper).map(any(ConversationEntity.class), any(Class.class));

        doReturn(responseOk).when(responseFactory).createResponse(any(Request.class), any(CreateConversationResponse.class));
        doReturn(responseNotFound).when(responseFactory).createResponse(any(Request.class), any(Status.class));
    }


    @Test
    public void testDoHandle() {
        assertThat(getConversationByIdsHandler.doHandle(request), is(responseOk));
    }

    @Test
    public void testBadRequest() {
        request.getData().setConversationIDs(null);
        assertThat(getConversationByIdsHandler.doHandle(request), is(responseNotFound));
    }

    @Test(expected = NullPointerException.class)
    public void testNullableRequest() {
        request = null;
        Response<GetConversationByIdsResponse> response = getConversationByIdsHandler.doHandle(request);
    }

    @Test
    public void testName() {
        assertThat(getConversationByIdsHandler.getName(), is("get_conversation_by_ids"));
    }
}
