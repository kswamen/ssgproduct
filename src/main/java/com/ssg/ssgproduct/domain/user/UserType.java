package com.ssg.ssgproduct.domain.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserType {
    NORMAL("일반"),
    ENTERPRISE("기업회원");

    private final String userTypeString;

    public static UserType nameOf(String name) {
        for (UserType value : UserType.values()) {
            if (value.userTypeString.equals(name)) {
                return value;
            }
        }
        return null;
    }
}
