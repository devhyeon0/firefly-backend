package com.firefly.member.controller;

import com.firefly.member.dto.MemberUpdateDto;
import com.firefly.member.dto.MemberCreationDto;
import com.firefly.member.dto.MemberResponseDto;
import com.firefly.member.entity.Member;
import com.firefly.member.mapper.MemberMapper;
import com.firefly.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper mapper;

    @PostMapping
    public ResponseEntity<Objects> postMember(@Valid @RequestBody MemberCreationDto requestBody) {
        memberService.createMember(mapper.memberPostDtoToMember(requestBody), requestBody.getEmail());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemberResponseDto> patchMember(@PathVariable("id") Long memberId,
                                                         @RequestBody MemberUpdateDto requestBody) {
        Member member = memberService.updateMember(memberId, mapper.memberPatchDtoToMember(requestBody));

        return ResponseEntity.ok(mapper.memberToMemberResponseDto(member));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable("id") Long memberId) {
        Member member = memberService.findMember(memberId);

        return ResponseEntity.ok(mapper.memberToMemberResponseDto(member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Objects> deleteMember(@PathVariable("id") Long memberId) {
        memberService.deleteMember(memberId);

        return ResponseEntity.noContent().build();
    }
}
