package com.ssg.ssgproduct.domain.product.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductType {
    NORMAL("일반"),
    ENTERPRISE("기업회원상품");

    private final String itemTypeString;

    public static ProductType nameOf(String name) {
        for (ProductType value : ProductType.values()) {
            if (value.itemTypeString.equals(name)) {
                return value;
            }
        }
        return null;
    }
}
