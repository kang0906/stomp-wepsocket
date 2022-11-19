package com.example.messagingstompwebsocket.repository;

import com.example.messagingstompwebsocket.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
