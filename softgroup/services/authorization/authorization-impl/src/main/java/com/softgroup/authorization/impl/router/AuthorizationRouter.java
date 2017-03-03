package com.softgroup.authorization.impl.router;

import com.softgroup.authorization.api.router.AuthorizationRouterHandler;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.api.AbstractRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 23:02
 */
@Component
public class AuthorizationRouter
        extends AbstractRouterHandler<AbstractRequestHandler>
            implements AuthorizationRouterHandler {

    @Override
    public String getName() {
        return "authorization";
    }

}
