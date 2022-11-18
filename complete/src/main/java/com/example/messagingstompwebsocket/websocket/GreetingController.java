package com.example.messagingstompwebsocket.websocket;

import com.example.messagingstompwebsocket.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@MessageMapping("/hello/{id}")
	public void greeting2(@DestinationVariable("id") String id, MessageDto message) throws Exception {

		simpMessagingTemplate.convertAndSend("/topic/greetings/" + id , new MessageDto(message.getUserName(), message.getUserId(),"Hi "+ HtmlUtils.htmlEscape(message.getUserName()) + "!"));
	}
}
