package com.example.messagingstompwebsocket.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ChatRoom {

    @Id
    private Long chatRoomId;

    @Column
    private String userIdList;

    @Column
    private String userNameList;

    @Column
    private String roomName;

}
