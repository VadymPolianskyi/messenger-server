package com.softgroup.ws.frontend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.socket.config.annotation.*;

/**
 * Author: vadym_polyanski
 * Date: 07.04.17
 * Time: 11:25
 */
@EnableWebSocket
@ComponentScan(basePackages = {
        "com.softgroup.ws.frontend"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class))
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler(), "/messenger/socket")
                .setAllowedOrigins("*")
                .addInterceptors(tokenValidatorHandshakeInterceptor());;
    }


    @Bean
    public WebSocketHandler handler() {
        return new WebSocketHandler();
    }

    @Bean
    public TokenValidatorHandshakeInterceptor tokenValidatorHandshakeInterceptor() {
        return new TokenValidatorHandshakeInterceptor();
    }
}
