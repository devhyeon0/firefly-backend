package com.firefly.post.entity;

import lombok.Getter;

public enum PostStatus {
    ACTIVE("모집중"),
    CLOSED("모집종료"),
    DELETED("게시글 삭제");

    @Getter
    private final String status;

    PostStatus(String status) {
        this.status = status;
    }
}
