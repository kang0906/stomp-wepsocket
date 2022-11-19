package com.example.messagingstompwebsocket.controller;

import com.example.messagingstompwebsocket.dto.ResponseDto;
import com.example.messagingstompwebsocket.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;
    @GetMapping("/chatroom")
    public ResponseDto getChatRoom(@RequestParam Long id){       // 채팅방 목록 조회 ( 재접속시 )

        log.info("member [ {} ] called getChatRoom", id);
        return new ResponseDto("success", chatService.getChatRoom(id));
    }


    @GetMapping("/chatroom/{id}/history")
    public ResponseDto getChatRoomHistory(@PathVariable String id){     // todo : 채팅 기록 조회 ( 재접속시 )

        return new ResponseDto(null, null);
    }

}


