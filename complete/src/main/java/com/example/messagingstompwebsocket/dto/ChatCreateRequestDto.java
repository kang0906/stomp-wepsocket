package com.example.messagingstompwebsocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class ChatCreateRequestDto {

    private String userIdList;
    private String userNameList;
    private String roomName;
}
