package com.firefly.post.entity;

import com.firefly.common.audit.BaseAuditable;
import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Entity
public class Post extends BaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String text;

    private Integer recruitMember;

    private RecruitField recruitField;

    private RecruitType recruitType;

    private String contact;

    private String contactLink;

    private String techStack;

    private LocalDateTime deadline;

    private String estimatedPeriod;

    private PostStatus status;

    private Long views;
}
