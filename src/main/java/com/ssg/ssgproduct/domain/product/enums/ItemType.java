package com.ssg.ssgproduct.domain.product.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemType {
    NORMAL("일반"),
    ENTERPRISE("기업회원상품");

    private final String itemTypeString;

    public static ItemType nameOf(String name) {
        for (ItemType value : ItemType.values()) {
            if (value.itemTypeString.equals(name)) {
                return value;
            }
        }
        return null;
    }
}
