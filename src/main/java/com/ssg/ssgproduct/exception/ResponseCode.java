package com.ssg.ssgproduct.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    // 200
    OK(HttpStatus.OK, 200, "OK"),
    NO_AVAIL_PROMOTION(HttpStatus.OK, 200, "적용할 수 있는 프로모션이 존재하지 않습니다."),

    // 400
    EXITED_CUSTOMER(HttpStatus.BAD_REQUEST, 404, "탈퇴한 회원은 상품 조회가 불가능합니다."),

    // 500
    PRODUCT_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, 500, "부합하는 상품이 존재하지 않습니다."),
    CUSTOMER_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, 500, "부합하는 소비자가 존재하지 않습니다."),
    PROMOTION_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, 500, "부합하는 프로모션이 존재하지 않습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "서버 오류입니다. 잠시 후 다시 시도해 주세요.");

    private HttpStatus status;
    private int code;
    private String message;
}
