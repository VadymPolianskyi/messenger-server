package com.softgroup.ws.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

/**
 * Author: vadym_polyanski
 * Date: 07.04.17
 * Time: 11:25
 */
@Configuration
@EnableWebSocket
@ComponentScan(basePackages = {
        "com.softgroup.ws"})
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler(), "/messenger/socket")
                .addInterceptors(new HttpSessionHandshakeInterceptor());;
    }


    @Bean
    public WebSocketHandler handler() {
        return new WebSocketHandler();
    }
}
