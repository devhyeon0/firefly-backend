package com.firefly.member.entity;

import com.firefly.common.audit.BaseAuditable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.sql.Timestamp;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String nickname;

    @Column(length = 100, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberRole memberRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoginProvider provider;

    @Column(nullable = false)
    private String  interestStack;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobRole jobRole;

    @Builder
    public Member(String email, String nickname, String password, MemberRole memberRole, MemberStatus status, LoginProvider provider, String interestStack, JobRole jobRole) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.memberRole = memberRole;
        this.status = status;
        this.provider = provider;
        this.interestStack = interestStack;
        this.jobRole = jobRole;
    }

    public void update(Long id, String email, String nickname, String password, String interestStack, JobRole jobRole) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.interestStack = interestStack;
        this.jobRole = jobRole;
    }
}
