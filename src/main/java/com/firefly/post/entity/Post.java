package com.firefly.post.entity;

import com.firefly.common.audit.BaseEntity;
import com.firefly.member.entity.Member;
import com.firefly.post.dto.PostUpdateDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static jakarta.persistence.EnumType.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Integer recruitMember;

    @Enumerated(STRING)
    @Column(nullable = false)
    private RecruitField recruitField;

    @Enumerated(STRING)
    @Column(nullable = false)
    private RecruitType recruitType;

    @Column(nullable = false)
    private String contact;

    private String contactLink;

    @Column(nullable = false)
    private String techStack;

    @Column(nullable = false)
    private LocalDate deadline;

    @Column(nullable = false)
    private String estimatedPeriod;

    @Enumerated(STRING)
    @Column(nullable = false)
    private PostStatus status;

    @Column(nullable = false)
    private Long views;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    public void setMember(Member member) {
        this.member = member;
        member.getPosts().add(this);
    }

    @Builder
    public Post(String title, String content, Integer recruitMember, RecruitField recruitField, RecruitType recruitType, String contact, String contactLink, String techStack, LocalDate deadline, String estimatedPeriod, PostStatus status, Long views, Member member) {
        this.title = title;
        this.content = content;
        this.recruitMember = recruitMember;
        this.recruitField = recruitField;
        this.recruitType = recruitType;
        this.contact = contact;
        this.contactLink = contactLink;
        this.techStack = techStack;
        this.deadline = deadline;
        this.estimatedPeriod = estimatedPeriod;
        this.status = status;
        this.views = views;
        this.member = member;
    }

    public void update(PostUpdateDto postDto) {
        Optional.ofNullable(postDto.getTitle()).ifPresent(value -> this.title = value);
        Optional.ofNullable(postDto.getContent()).ifPresent(value -> this.content = value);
        Optional.ofNullable(postDto.getRecruitMember()).ifPresent(value -> this.recruitMember = value);
        Optional.ofNullable(postDto.getRecruitField()).ifPresent(value -> this.recruitField = value);
        Optional.ofNullable(postDto.getRecruitType()).ifPresent(value -> this.recruitType = value);
        Optional.ofNullable(postDto.getContact()).ifPresent(value -> this.contact = value);
        Optional.ofNullable(postDto.getContactLink()).ifPresent(value -> this.contactLink = value);
        Optional.ofNullable(postDto.getTechStack()).ifPresent(value -> this.techStack = value);
        Optional.ofNullable(postDto.getDeadline()).ifPresent(value -> this.deadline = value);
        Optional.ofNullable(postDto.getEstimatedPeriod()).ifPresent(value -> this.estimatedPeriod = value);
        Optional.ofNullable(postDto.getStatus()).ifPresent(value -> this.status = value);
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }
}
