package com.firefly.member.dto;

import com.firefly.member.entity.JobRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberUpdateDto {

    private String nickname;
    private String password;
    private String interestStack;
    private JobRole jobRole;
}
