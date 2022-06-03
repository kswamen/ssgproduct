package com.ssg.ssgproduct.exception.exceptioncase;

import com.ssg.ssgproduct.exception.ResponseCode;
import lombok.Getter;

@Getter
public class NoAvailPromotionException extends RuntimeException {
    private final ResponseCode responseCode;

    public NoAvailPromotionException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }
}
