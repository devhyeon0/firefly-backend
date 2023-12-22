package com.firefly.post.dto;

import com.firefly.post.entity.PostStatus;
import com.firefly.post.entity.RecruitField;
import com.firefly.post.entity.RecruitType;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PostUpdateDto {

    private String title;
    private String content;
    private Integer recruitMember;
    private RecruitField recruitField;
    private RecruitType recruitType;
    private String contact;
    private String contactLink;
    private String techStack;
    private LocalDate deadline;
    private String estimatedPeriod;
    private PostStatus status;
}
