package com.ssg.ssgproduct.domain.customer.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CustomerStat {
    NORMAL("정상"),
    QUIT("탈퇴");

    private final String userStatString;

    public static CustomerStat nameOf(String name) {
        for (CustomerStat value : CustomerStat.values()) {
            if (value.userStatString.equals(name)) {
                return value;
            }
        }
        return null;
    }
}
