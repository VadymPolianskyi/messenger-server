package com.softgroup.messenger.impl.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.messenger.api.router.MessengerRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 23:02
 */
@Component
public class MessengerRouter extends AbstractRouterHandler implements MessengerRouterHandler {

    @Override
    public String getName() {
        return "messenger";
    }

}
