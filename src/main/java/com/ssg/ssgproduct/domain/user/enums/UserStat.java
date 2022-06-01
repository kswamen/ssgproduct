package com.ssg.ssgproduct.domain.user.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
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
