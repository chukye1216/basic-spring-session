package com.sparta.basicspringsession.controller;

import com.sparta.basicspringsession.dto.*;
import com.sparta.basicspringsession.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMembers(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
        return ResponseEntity.ok(memberService.saveMembers(memberSaveRequestDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/members/{memberID}")
    public ResponseEntity<MemberDetailResponseDto> getMember(@PathVariable Long memberID) {
        return ResponseEntity.ok(memberService.getMember(memberID));
    }

    @PutMapping("/members/{memberID}")
    public ResponseEntity<MemberUpdateResponseDto> updateMember(@PathVariable Long memberID, MemberUpdateRequsetDto memberUpdateRequsetDto) {
        return ResponseEntity.ok(memberService.updateMember(memberID, memberUpdateRequsetDto));
    }

    @DeleteMapping("/members/{memberID}")
    public void deleteMember(@PathVariable Long memberID) {
        memberService.deleteMember(memberID);
    }

}
