package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.entitiy.Member;
import com.sparta.basicspringsession.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMembers(MemberSaveRequestDto memberSaveRequestDto) {
        Member newMember = new Member(memberSaveRequestDto.getName());
        Member savedMember = memberRepository.save(newMember);
        return new MemberSaveResponseDto(savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberSimpleResponseDto> memberSimpleResponseDtos = new ArrayList<>();

        for (Member member : members) {
            memberSimpleResponseDtos.add(new MemberSimpleResponseDto(member.getId(), member.getName()));
        }
        return memberSimpleResponseDtos;
    }

    public MemberDetailResponseDto getMember(Long memberID) {
        Member member = memberRepository.findById(memberID).orElseThrow(() -> new NullPointerException("찾는 멤버가 없습니다."));

        return new MemberDetailResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public MemberUpdateResponseDto updateMember(Long memberID, MemberUpdateRequsetDto memberUpdateRequsetDto) {
        Member member = memberRepository.findById(memberID).orElseThrow(() -> new NullPointerException("찾는 멤버가 없습니다."));
        member.update(memberUpdateRequsetDto.getName());

        return new MemberUpdateResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public void deleteMember(Long memberID) {
        Member member = memberRepository.findById(memberID).orElseThrow(() -> new NullPointerException("찾는 멤버가 없습니다."));
        memberRepository.delete(member);
    }
}

