package com.softgroup.ws.frontend.configuration;

import com.softgroup.ws.frontend.WebSocketConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 17:49
 */
public class WSAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{WebSocketConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WSApplicationConfiguration.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
