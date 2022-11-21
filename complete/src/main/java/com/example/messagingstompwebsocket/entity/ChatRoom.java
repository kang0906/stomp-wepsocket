package com.example.messagingstompwebsocket.entity;

import com.example.messagingstompwebsocket.dto.ChatCreateRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ChatRoom {
    public ChatRoom(ChatCreateRequestDto dto) {
        this.userIdList = dto.getUserIdList();
        this.userNameList = dto.getUserNameList();
        this.roomName = dto.getRoomName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatRoomId;

    @Column
    private String userIdList;

    @Column
    private String userNameList;

    @Column
    private String roomName;

}
