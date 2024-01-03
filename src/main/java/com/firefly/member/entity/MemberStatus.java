package com.firefly.member.entity;

import lombok.Getter;

@Getter
public enum MemberStatus {
    ACTIVE("활동중"),
    INACTIVE("휴면 상태");

    private final String status;

    MemberStatus(String status) {
        this.status = status;
    }
}
