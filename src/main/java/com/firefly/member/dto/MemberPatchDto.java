package com.firefly.member.dto;

import com.firefly.member.entity.JobRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberPatchDto {

    private Long id;
    private String nickname;
    private String password;
    private String interestStack;
    private JobRole jobRole;
}
