package com.firefly.post.entity;

import com.firefly.common.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Integer recruitMember;

    @Column(nullable = false)
    private RecruitField recruitField;

    @Column(nullable = false)
    private RecruitType recruitType;

    @Column(nullable = false)
    private String contact;

    private String contactLink;

    @Column(nullable = false)
    private String techStack;

    @Column(nullable = false)
    private LocalDateTime deadline;

    @Column(nullable = false)
    private String estimatedPeriod;

    @Column(nullable = false)
    private PostStatus status;

    @Column(nullable = false)
    private Long views;
}
