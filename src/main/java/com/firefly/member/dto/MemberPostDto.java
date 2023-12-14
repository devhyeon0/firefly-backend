package com.firefly.member.dto;

import com.firefly.member.entity.JobRole;
import com.firefly.member.entity.LoginProvider;
import com.firefly.member.entity.MemberRole;
import com.firefly.member.entity.MemberStatus;

public class MemberPostDto {

    private String email;
    private String nickname;
    private String password;
    private MemberRole memberRole;
    private MemberStatus status;
    private LoginProvider provider;
    private String  interestStack;
    private JobRole jobRole;
}
