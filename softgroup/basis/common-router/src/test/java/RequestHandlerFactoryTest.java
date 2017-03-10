import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.api.factory.RequestHandlerFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Author: vadym
 * Date: 04.03.17
 * Time: 15:58
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestHandlerFactoryTest {
    @InjectMocks
    RequestHandlerFactory requestHandlerFactory;

    private AbstractRequestHandler handlerFirst;
    private AbstractRequestHandler handlerSecond;
    private Request firstRequest;
    private Request secondRequest;

    @Spy
    private List<AbstractRequestHandler> handlerList = new ArrayList<>();

    @Before
    public void init() {
        handlerFirst = Mockito.mock(AbstractRequestHandler.class);
        handlerSecond = Mockito.mock(AbstractRequestHandler.class);

        when(handlerFirst.getName()).thenReturn("handlerFirst");
        when(handlerSecond.getName()).thenReturn("handlerSecond");
        ActionHeader firstHeader = Mockito.mock(ActionHeader.class);
        ActionHeader secondHeader = Mockito.mock(ActionHeader.class);

        handlerList.add(handlerFirst);
        handlerList.add(handlerSecond);

        firstRequest = Mockito.mock(Request.class);
        secondRequest = Mockito.mock(Request.class);

        when(firstRequest.getHeader()).thenReturn(firstHeader);
        when(secondRequest.getHeader()).thenReturn(secondHeader);

        when(firstHeader.getCommand()).thenReturn("handlerFirst");
        when(firstHeader.getCommand()).thenReturn("handlerSecond");

        requestHandlerFactory.init();
    }

    @Test
    public void testGetHandler() {
//        assertThat(requestHandlerFactory.getHandler(null), nullValue());
//        assertThat(requestHandlerFactory.getHandler(firstRequest), is(handlerFirst));
        assertThat(requestHandlerFactory.getHandler(secondRequest), is(handlerSecond));
    }


}
