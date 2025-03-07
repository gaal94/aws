package myconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import annotation.springmvc.websocket.ChatWebSocketHandler;

@Configuration
@EnableWebSocket
public class MyWebsocketConfig implements WebSocketConfigurer {
	@Autowired
	ChatWebSocketHandler websocketHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(websocketHandler, "/chatws");
	}

}
