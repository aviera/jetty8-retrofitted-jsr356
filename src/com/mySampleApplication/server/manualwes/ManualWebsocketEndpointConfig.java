package com.mySampleApplication.server.manualwes;

import javax.websocket.Decoder;
import javax.websocket.Encoder;
import javax.websocket.Extension;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author ariel.viera@gmail.com (Ariel Viera)
 */
public class ManualWebsocketEndpointConfig implements ServerEndpointConfig {
    @Override
    public Class<?> getEndpointClass() {
        return ManualEndpoint.class;
    }

    @Override
    public String getPath() {
        return "/reping";
    }

    @Override
    public List<String> getSubprotocols() {
        return Collections.emptyList();
    }

    @Override
    public List<Extension> getExtensions() {
        return Collections.emptyList();

    }

    @Override
    public Configurator getConfigurator() {
        return new Configurator(){};
    }

    @Override
    public List<Class<? extends Encoder>> getEncoders() {
        return Collections.emptyList();

    }

    @Override
    public List<Class<? extends Decoder>> getDecoders() {
        return Collections.emptyList();
    }

    @Override
    public Map<String, Object> getUserProperties() {
        return Collections.emptyMap();
    }
}
