import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.factory.RouterHandlerFactory;
import com.softgroup.common.router.impl.FirstRouterHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Author: vadym_polyanski
 * Date: 28.03.17
 * Time: 18:24
 */
@RunWith(MockitoJUnitRunner.class)
public class FirstRouterHandlerTest {
    @InjectMocks
    private FirstRouterHandler firstRouterHandler;

    private RouterHandlerFactory routerHandlerFactory = Mockito.mock(RouterHandlerFactory.class);
    private AbstractRouterHandler router = Mockito.mock(AbstractRouterHandler.class);
    private Request request;
    private Response response;

    @Before
    public void init() {
        when(routerHandlerFactory.getHandler(request)).thenReturn(router);
        when(router.handle(request)).thenReturn(response);
    }

    @Test
    public void handleTest() {
        assertThat(firstRouterHandler.handle(request), is(response));
    }
}
