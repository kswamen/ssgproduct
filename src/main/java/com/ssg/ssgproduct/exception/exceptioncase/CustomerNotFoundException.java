package com.ssg.ssgproduct.exception.exceptioncase;

import com.ssg.ssgproduct.domain.customer.Customer;
import com.ssg.ssgproduct.exception.ResponseCode;
import lombok.Getter;

@Getter
public class CustomerNotFoundException extends RuntimeException {
    private final ResponseCode responseCode;

    public CustomerNotFoundException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }
}
