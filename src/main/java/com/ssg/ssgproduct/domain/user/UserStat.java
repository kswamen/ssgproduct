package com.ssg.ssgproduct.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStat {
    NORMAL("정상"),
    QUIT("탈퇴");

    private final String userStatString;

    public static UserStat nameOf(String name) {
        for (UserStat value : UserStat.values()) {
            if (value.userStatString.equals(name)) {
                return value;
            }
        }
        return null;
    }
}
