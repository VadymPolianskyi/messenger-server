package com.softgroup.profile.impl.router;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.profile.api.router.ProfileRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:49
 */
@Component
public class ProfileRouter extends AbstractRouterHandler<AbstractRequestHandler> implements ProfileRouterHandler{

    public String getName() {
        return "profile";
    }

}
