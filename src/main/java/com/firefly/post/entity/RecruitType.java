package com.firefly.post.entity;

import lombok.Getter;

public enum RecruitType {
    PROJECT("프로젝트"),
    STUDY("스터디");

    @Getter
    private final String name;

    RecruitType(String name) {
        this.name = name;
    }
}
