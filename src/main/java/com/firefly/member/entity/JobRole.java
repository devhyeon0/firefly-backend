package com.firefly.member.entity;

import lombok.Getter;

@Getter
public enum JobRole {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드"),
    PRODUCT_MANAGER("기획자"),
    PROJECT_MANAGER("PM"),
    DESIGNER("디자이너"),
    ANDROID("안드로이드"),
    IOS("IOS"),
    DEVOPS("DEVOPS");

    private final String name;

    JobRole(String name) {
        this.name = name;
    }
}