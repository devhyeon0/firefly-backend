package com.firefly.member.entity;

import lombok.Getter;

@Getter
public enum LoginProvider {
    NAVER("네이버"),
    KAKAO("카카오"),
    GOOGLE("구글"),
    GITHUB("깃허브");

    private final String name;

    LoginProvider(String name) {
        this.name = name;
    }
}
