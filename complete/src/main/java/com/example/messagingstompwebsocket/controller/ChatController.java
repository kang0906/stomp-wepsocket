package com.example.messagingstompwebsocket.controller;

import com.example.messagingstompwebsocket.dto.ChatCreateRequestDto;
import com.example.messagingstompwebsocket.dto.ResponseDto;
import com.example.messagingstompwebsocket.entity.Member;
import com.example.messagingstompwebsocket.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;
    @GetMapping("/chatroom")
    public ResponseDto getChatRoom(@RequestParam Long id){       // todo : 채팅방 목록 조회 ( 재접속시 ) - 사용자 인증, 인가 정보 필요 @AuthenticationPrincipal UserDetailsImpl userDetails,

        log.info("member [ {} ] called getChatRoom", id);
        return new ResponseDto("success", chatService.getChatRoom(id));
    }


    @GetMapping("/chatroom/{id}/history")
    public ResponseDto getChatRoomHistory(@PathVariable String id){     // todo : 채팅 기록 조회 ( 재접속시 ) - 사용자 인증, 인가 정보 필요 @AuthenticationPrincipal UserDetailsImpl userDetails,

        return new ResponseDto(null, null);
    }

    @PostMapping("/chatroom")
    public ResponseDto createChatRoom(@RequestBody ChatCreateRequestDto dto){       // todo : 채팅방 생성 - 사용자 인증, 인가 정보 필요 @AuthenticationPrincipal UserDetailsImpl userDetails,

        log.info("member [ 수정필요(인증정보 부분) ] called createChatRoom");
        return new ResponseDto("success", chatService.createChatRoom(new Member(), dto));
    }

    @DeleteMapping("/chatroom/{id}")
    public ResponseDto deleteChatRoom(@PathVariable String id){       // todo : 채팅방 삭제 - 사용자 인증, 인가 정보 필요 @AuthenticationPrincipal UserDetailsImpl userDetails,

        log.info("member [ 수정필요(인증정보 부분) ] called deleteChatRoom");
        return new ResponseDto("success", null);
    }

}


