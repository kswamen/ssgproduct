package com.ssg.ssgproduct.domain.customer.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssg.ssgproduct.exception.ResponseCode;
import com.ssg.ssgproduct.exception.exceptioncase.NoAvailEnumValueException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CustomerType {
    NORMAL("일반"),
    ENTERPRISE("기업회원");

    private final String userTypeString;

    public static CustomerType nameOf(String name) {
        for (CustomerType value : CustomerType.values()) {
            if (value.userTypeString.equals(name)) {
                return value;
            }
        }
        throw new NoAvailEnumValueException(ResponseCode.NO_AVAIL_ENUM_VALUE);
    }
}
