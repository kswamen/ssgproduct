package com.ssg.ssgproduct.exception.exceptioncase;

import com.ssg.ssgproduct.exception.ResponseCode;
import lombok.Getter;

@Getter
public class ExitedCustomerException extends RuntimeException {
    private final ResponseCode responseCode;

    public ExitedCustomerException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }
}
