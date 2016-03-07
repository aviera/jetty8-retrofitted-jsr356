package com.mySampleApplication.server.manualwes;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;

/**
 * @author ariel.viera@gmail.com (Ariel Viera)
 */
public class ManualEndpoint extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        System.out.println("open");
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String s) {
                System.out.println("Received " + s);
                try {
                    session.getBasicRemote().sendText("hey hey hey hey!");
                } catch (IOException e) {
                    System.out.println("Error");
                }
            }
        });
        try {
            session.getBasicRemote().sendText("hello");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }


}
