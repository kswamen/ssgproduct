package com.ssg.ssgproduct.exception.exceptioncase;

import com.ssg.ssgproduct.exception.ResponseCode;
import lombok.Getter;

@Getter
public class PromotionNotFoundException extends RuntimeException {
    private final ResponseCode responseCode;

    public PromotionNotFoundException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }
}
