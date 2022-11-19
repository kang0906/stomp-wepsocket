package com.example.messagingstompwebsocket.repository;

import com.example.messagingstompwebsocket.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
