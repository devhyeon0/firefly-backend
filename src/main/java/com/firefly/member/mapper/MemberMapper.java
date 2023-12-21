package com.firefly.member.mapper;

import com.firefly.member.dto.MemberUpdateDto;
import com.firefly.member.dto.MemberCreationDto;
import com.firefly.member.dto.MemberResponseDto;
import com.firefly.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoToMember(MemberCreationDto memberDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
    Member memberPatchDtoToMember(MemberUpdateDto memberDto);
}
