package com.firefly.member.entity;

import com.firefly.common.audit.BaseTimeEntity;
import com.firefly.member.dto.MemberUpdateDto;
import com.firefly.post.entity.Like;
import com.firefly.post.entity.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
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

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        this.posts.add(post);
    }

    @OneToMany(mappedBy = "member")
    private List<Like> likes = new ArrayList<>();

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

    public void update(MemberUpdateDto memberDto) {
        Optional.ofNullable(memberDto.getNickname()).ifPresent(value -> this.nickname = value);
        Optional.ofNullable(memberDto.getPassword()).ifPresent(value -> this.password = value);
        Optional.ofNullable(memberDto.getInterestStack()).ifPresent(value -> this.interestStack = value);
        Optional.ofNullable(memberDto.getJobRole()).ifPresent(value -> this.jobRole = value);
    }
}
