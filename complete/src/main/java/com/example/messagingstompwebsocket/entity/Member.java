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
public class Member {

    @Id
    private Long memberId;

    @Column
    private String name;

    @Column
    private String chatRoomIdList;
}
