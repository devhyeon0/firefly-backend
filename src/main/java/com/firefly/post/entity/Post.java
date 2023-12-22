package com.firefly.post.entity;

import com.firefly.common.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

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

    @Column(nullable = false)
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

    @Builder
    public Post(String title, String content, Integer recruitMember, RecruitField recruitField, RecruitType recruitType, String contact, String contactLink, String techStack, LocalDate deadline, String estimatedPeriod, PostStatus status, Long views) {
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
    }

    public void update(String title, String content, Integer recruitMember, RecruitField recruitField, RecruitType recruitType, String contact, String contactLink, String techStack, LocalDate deadline, String estimatedPeriod, PostStatus status) {
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
    }
}
