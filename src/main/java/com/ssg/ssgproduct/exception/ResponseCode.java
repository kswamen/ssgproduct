package com.ssg.ssgproduct.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    // 200
    OK(HttpStatus.OK, 200, "OK", "OK"),
    NO_AVAIL_PROMOTION(HttpStatus.OK, 200, "적용할 수 있는 프로모션이 존재하지 않습니다.", "NO_AVAIL_PROMOTION"),

    // 400
    EXITED_CUSTOMER(HttpStatus.BAD_REQUEST, 404, "탈퇴한 회원은 상품 조회가 불가능합니다.", "EXITED_CUSTOMER"),
    NO_AVAIL_ENUM_VALUE(HttpStatus.BAD_REQUEST, 404, "적용 가능한 카테고리 목록인지 확인하세요.", "NO_AVAIL_ENUM_VALUE"),
    INVALID_DATETIME_FORMAT(HttpStatus.BAD_REQUEST, 404, "날짜 형식이 올바른지 확인하세요(yyyy-MM-dd).", "INVALID_DATETIME_FORMAT"),
    STARTDATE_AFTER_ENDDATE(HttpStatus.BAD_REQUEST, 404, "시작 날짜는 종료 날짜보다 앞서야 합니다.", "STARTDATE_AFTER_ENDDATE"),

    // 500
    PRODUCT_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, 500, "부합하는 상품이 존재하지 않습니다.", "PRODUCT_NOT_FOUND"),
    CUSTOMER_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, 500, "부합하는 소비자가 존재하지 않습니다.", "CUSTOMER_NOT_FOUND"),
    PROMOTION_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, 500, "부합하는 프로모션이 존재하지 않습니다.", "PROMOTION_NOT_FOUND"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "서버 오류입니다. 잠시 후 다시 시도해 주세요.", "INTERNAL_SERVER_ERROR");

    private HttpStatus status;
    private int code;
    private String message;
    private String specificCode;
}
