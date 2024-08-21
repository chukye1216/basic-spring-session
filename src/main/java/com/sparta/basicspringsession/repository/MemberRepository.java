package com.sparta.basicspringsession.repository;

import com.sparta.basicspringsession.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
