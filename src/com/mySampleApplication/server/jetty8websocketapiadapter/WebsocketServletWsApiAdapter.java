package com.mySampleApplication.server.jetty8websocketapiadapter;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ariel.viera@gmail.com (Ariel Viera)
 */
public class WebsocketServletWsApiAdapter extends WebSocketServlet {
    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest httpServletRequest, String s) {
        return null;
    }
}
