package com.softgroup.ws.frontend;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

/**
 * Author: vadym_polyanski
 * Date: 07.04.17
 * Time: 12:01
 */
@Component
public class WebSocketHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println(message.getPayload());
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws IOException {
    }



    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {

    }
}
