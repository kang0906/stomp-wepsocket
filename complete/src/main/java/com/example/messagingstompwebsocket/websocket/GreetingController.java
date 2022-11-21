package com.example.messagingstompwebsocket.websocket;

import com.example.messagingstompwebsocket.dto.MessageDto;
import com.example.messagingstompwebsocket.entity.ChatRoom;
import com.example.messagingstompwebsocket.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GreetingController {

	private final SimpMessagingTemplate simpMessagingTemplate;
	private final ChatRoomRepository chatRoomRepository;

//	@MessageMapping("/hello/{id}")
	public void greeting2(@DestinationVariable("id") String id, MessageDto message) throws Exception {
		log.info("called greeting2 with id : {}", id);
		simpMessagingTemplate.convertAndSend("/topic/greetings/" + id ,
				new MessageDto("", message.getChatRoomId(), message.getUserName(),"Hi "+ HtmlUtils.htmlEscape(message.getUserName()) + "!"));
	}

	@MessageMapping("/hello/{id}")
	public void socketHandle(@DestinationVariable("id") String id, MessageDto message) throws Exception {

		log.info("socketHandle: id={}, MessageDto={}",id,message);
//		if(message.getAction().equals("MESSAGE")){
//
//		}else if(message.getAction().equals("CREATE")){
//
//		}else if(message.getAction().equals("LEAVE")){
//
//		}else{
//
//		}	// 채팅방 생성, 나가기는 http 요청으로 처리하려고함

		if(message.getAction().equals("MESSAGE")){
			ChatRoom chatRoom = chatRoomRepository.findById(message.getChatRoomId()).orElse(null);	// todo : null 예외처리
			String[] s = chatRoom.getUserIdList().split(" ");
			for (String s1 : s) {
				log.trace("socketHandle MESSAGE send to : (id){}",s1);
				simpMessagingTemplate.convertAndSend("/topic/greetings/" + s1 ,
						new MessageDto(message.getAction(), message.getChatRoomId(), message.getUserName(),message.getContent()));
			}

		}else{
			// todo : 예외처리 " -알수없는 요청- "
		}
		simpMessagingTemplate.convertAndSend("/topic/greetings/" + id ,
				new MessageDto("", message.getChatRoomId(), message.getUserName(),"Hi "+ HtmlUtils.htmlEscape(message.getUserName()) + "!"));
	}
}
