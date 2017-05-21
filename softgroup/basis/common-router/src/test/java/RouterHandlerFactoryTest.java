import com.softgroup.common.loger.LoggerConfig;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.factory.RouterHandlerFactory;
import com.softgroup.common.router.impl.FirstRouterHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

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
@ContextConfiguration(classes={LoggerConfig.class})
public class RouterHandlerFactoryTest {
    @InjectMocks
    private RouterHandlerFactory routerHandlerFactory;

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
    @Spy
    private Logger log = LoggerFactory.getLogger(FirstRouterHandler.class);

    @Before
    public void init() {
        firstRequest = new Request();
        firstHeader = new ActionHeader();
        firstHeader.setType("firstRouter");
        firstRequest.setHeader(firstHeader);

        secondRequest = new Request();
        secondHeader = new ActionHeader();
        secondHeader.setType("secondRouter");
        secondRequest.setHeader(secondHeader);


        when(firstRouter.getName()).thenReturn("firstRouter");
        when(secondRouter.getName()).thenReturn("secondRouter");

        routerHandlers.add(firstRouter);
        routerHandlers.add(secondRouter);

        routerHandlerFactory.init();
    }

    @Test
    public void testGetHandler() {
        assertThat(routerHandlerFactory.getHandler(firstRequest), is(firstRouter));
        assertThat(routerHandlerFactory.getHandler(secondRequest), is(secondRouter));
    }

    @Test(expected = NullPointerException.class)
    public void testNullable() {
        assertThat(routerHandlerFactory.getHandler(null), nullValue());
    }


}