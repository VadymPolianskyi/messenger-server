package com.softgroup.rest.frontend.configuration;

import com.softgroup.authorization.impl.AuthorizationConfig;
import com.softgroup.common.cache.CacheConfig;
import com.softgroup.common.dao.impl.configuration.DaoConfig;
import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.common.jwt.impl.service.TokenConfig;
import com.softgroup.common.protocol.configuration.ProtocolConfig;
import com.softgroup.common.router.RouterConfig;
import com.softgroup.messenger.impl.MessengerConfig;
import com.softgroup.profile.impl.ProfileConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 17:47
 */

@Configuration
@ComponentScan(basePackages = {
        "com.softgroup.rest.frontend"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class))
@Import({DataMapperAppCfg.class,
        RouterConfig.class,
        AuthorizationConfig.class,
        ProfileConfig.class,
        MessengerConfig.class,
        TokenConfig.class,
        DaoConfig.class,
        CacheConfig.class,
        ProtocolConfig.class
})
public class RestApplicationConfiguration {
}