package com.firefly.post.entity;

import lombok.Getter;

@Getter
public enum PostStatus {
    ACTIVE("모집중"),
    CLOSED("모집종료"),
    DELETED("게시글 삭제");

    private final String status;

    PostStatus(String status) {
        this.status = status;
    }
}
