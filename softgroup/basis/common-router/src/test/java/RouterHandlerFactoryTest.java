import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.factory.RequestHandlerFactory;
import com.softgroup.common.router.api.factory.RouterHandlerFactory;
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
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Author: vadym_polyanski
 * Date: 28.03.17
 * Time: 18:01
 */
@RunWith(MockitoJUnitRunner.class)
public class RouterHandlerFactoryTest {
    @InjectMocks
    RouterHandlerFactory routerHandlerFactory;

    @Mock
    private AbstractRouterHandler firstRouter;
    @Mock
    private AbstractRouterHandler secondRouter;
    private Request firstRequest;
    private Request secondRequest;
    private ActionHeader firstHeader;
    private ActionHeader secondHeader;

    @Spy
    private List<AbstractRouterHandler> routerHandlers = new ArrayList<>();

    @Before
    public void init() {
        firstRequest = new Request();
        firstRequest.setHeader(new ActionHeader());
        firstRequest.getHeader().setType("firstRouter");

        secondRequest = new Request();
        secondRequest.setHeader(new ActionHeader());
        secondRequest.getHeader().setType("secondRouter");

        when(firstRouter.getName()).thenReturn("firstRouter");
        when(secondRouter.getName()).thenReturn("secondRouter");

        routerHandlers.add(firstRouter);
        routerHandlers.add(secondRouter);

        routerHandlerFactory.init();
    }

    @Test
    public void testGetHandler() {
        assertThat(routerHandlerFactory.getHandler(null), nullValue());
        assertThat(routerHandlerFactory.getHandler(firstRequest), is(firstRouter));
        assertThat(routerHandlerFactory.getHandler(secondRequest), is(secondRouter));
    }


}