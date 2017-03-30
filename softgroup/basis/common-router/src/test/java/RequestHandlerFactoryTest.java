import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.api.factory.RequestHandlerFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Author: vadym
 * Date: 04.03.17
 * Time: 15:58
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestHandlerFactoryTest {
    @InjectMocks
    RequestHandlerFactory requestHandlerFactory;

    @Mock
    private AbstractRequestHandler handlerFirst;
    @Mock
    private AbstractRequestHandler handlerSecond;
    private Request firstRequest;
    private Request secondRequest;
    private ActionHeader firstHeader;
    private ActionHeader secondHeader;

    @Spy
    private List<AbstractRequestHandler> handlers = new ArrayList<>();

    @Before
    public void init() {
        firstRequest = new Request();
        firstRequest.setHeader(new ActionHeader());
        firstRequest.getHeader().setCommand("handlerFirst");

        secondRequest = new Request();
        secondRequest.setHeader(new ActionHeader());
        secondRequest.getHeader().setCommand("handlerSecond");

        when(handlerFirst.getName()).thenReturn("handlerFirst");
        when(handlerSecond.getName()).thenReturn("handlerSecond");

        handlers.add(handlerFirst);
        handlers.add(handlerSecond);

        requestHandlerFactory.init();
    }

    @Test
    public void testGetHandler() {
        assertThat(requestHandlerFactory.getHandler(firstRequest), is(handlerFirst));
        assertThat(requestHandlerFactory.getHandler(secondRequest), is(handlerSecond));
    }


}
