package com.firefly.member.mapper;

import com.firefly.member.dto.MemberPostDto;
import com.firefly.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoToMember(MemberPostDto memberPostDto);
}
