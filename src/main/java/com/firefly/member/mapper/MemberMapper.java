package com.firefly.member.mapper;

import com.firefly.member.dto.MemberPatchDto;
import com.firefly.member.dto.MemberPostDto;
import com.firefly.member.dto.MemberResponseDto;
import com.firefly.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoToMember(MemberPostDto memberDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
    Member memberPatchDtoToMember(MemberPatchDto memberDto);
}
