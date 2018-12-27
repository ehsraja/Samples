package com.rhl.service.webSocket;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

//@Controller
public class ChatController {
	
	
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public  Greeting send(
	        String message)
	        throws Exception {
		 return new Greeting("Hello, " + HtmlUtils.htmlEscape(message + "!"));
	  
	}

}
