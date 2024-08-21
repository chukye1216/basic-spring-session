package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.MemberSaveRequestDto;
import com.sparta.basicspringsession.dto.MemberSaveResponseDto;
import com.sparta.basicspringsession.entitiy.Member;
import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMembers(MemberSaveRequestDto memberSaveRequestDto){
        Member newMember = new Member(memberSaveRequestDto.getName());
        Member savedMember = memberRepository.save(newMember);
        return new MemberSaveResponseDto(savedMember.getName());
    }

}
