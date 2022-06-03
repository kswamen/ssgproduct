package com.ssg.ssgproduct.domain.product.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DiscountType {
    RATE("정률할인"),
    AMOUNT("정액할인");

    private final String discountTypeString;
}
