package com.example.messagingstompwebsocket.controller;

import com.example.messagingstompwebsocket.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class ChatController {


    @GetMapping("/chatroom")
    public ResponseDto getChatRoom(@RequestParam Long id){       // todo : 채팅방 목록 조회 ( 재접속시 )

        log.info("member [ {} ] called getChatRoom", id);
        return new ResponseDto(null, null);
    }


    @GetMapping("/chatroom/{id}/history")
    public ResponseDto getChatRoomHistory(@PathVariable String id){     // todo : 채팅 기록 조회 ( 재접속시 )

        return new ResponseDto(null, null);
    }

}


