package com.example.messagingstompwebsocket.websocket;

import com.example.messagingstompwebsocket.dto.MessageDto;
import com.example.messagingstompwebsocket.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
@RequiredArgsConstructor
public class GreetingController {

	private final SimpMessagingTemplate simpMessagingTemplate;
	private final ChatRoomRepository chatRoomRepository;

	@MessageMapping("/hello/{id}")
	public void greeting2(@DestinationVariable("id") String id, MessageDto message) throws Exception {

		simpMessagingTemplate.convertAndSend("/topic/greetings/" + id ,
				new MessageDto("", message.getChatRoomId(), message.getUserName(),"Hi "+ HtmlUtils.htmlEscape(message.getUserName()) + "!"));
	}
}
