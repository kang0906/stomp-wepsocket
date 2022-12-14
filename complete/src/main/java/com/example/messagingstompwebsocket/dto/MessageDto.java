package com.example.messagingstompwebsocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private String action;
    private Long chatRoomId;
    private String userName;
    private String content;


}
