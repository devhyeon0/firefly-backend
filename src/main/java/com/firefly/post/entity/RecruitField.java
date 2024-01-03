package com.firefly.post.entity;

import lombok.Getter;

@Getter
public enum RecruitField {
    FRONTEND("프론트엔드"),
    BACKEND("백엔드"),
    IOS("IOS"),
    ANDROID("안드로이드"),
    DESIGNER("디자이너"),
    DEV_OPS("데브옵스"),
    PRODUCT_MANAGER("기획자");

    private final String name;

    RecruitField(String name) {
        this.name = name;
    }
}
