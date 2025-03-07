package annotation.springmvc.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	@RequestMapping("/chat")
	public String chatview(String id) {
		return "websocket/websocket";
	}
}
