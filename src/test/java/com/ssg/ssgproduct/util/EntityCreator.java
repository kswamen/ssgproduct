package com.ssg.ssgproduct.util;

import com.ssg.ssgproduct.domain.customer.Customer;
import com.ssg.ssgproduct.domain.customer.enums.CustomerStat;
import com.ssg.ssgproduct.domain.customer.enums.CustomerType;
import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotionproduct.PromotionProduct;

import java.time.LocalDate;

public class EntityCreator {
    public static Customer createUser() {
        return Customer.builder()
//                .userId(1L)
                .customerName("김석원")
                .customerStat(CustomerStat.NORMAL)
                .customerType(CustomerType.NORMAL)
                .build();
    }

    public static Customer createUser(CustomerStat stat, CustomerType type) {
        return Customer.builder()
//                .userId(1L)
                .customerName("김석원")
                .customerStat(stat)
                .customerType(type)
                .build();
    }

    public static Product createProduct() {
        return Product.builder()
                .productName("노브랜드 버터링")
                .productType(ProductType.ENTERPRISE)
                .productPrice(20000L)
                .productDisplayStartTime(LocalDate.of(2022, 1, 1))
                .productDisplayEndTime(LocalDate.of(2099, 6, 2))
                .build();
    }

    public static Product createProduct(ProductType type) {
        return Product.builder()
                .productName("노브랜드 버터링")
                .productType(type)
                .productPrice(20000L)
                .productDisplayStartTime(LocalDate.of(2022, 1, 1))
                .productDisplayEndTime(LocalDate.of(2099, 6, 2))
                .build();
    }

    public static PromotionProduct createPromotionProduct() {
        return PromotionProduct.builder()
                .product(createProduct())
                .promotion(createPromotion())
                .build();
    }

    public static Promotion createPromotion() {
        return Promotion.builder()
                .promotionNm("2022 쓱데이")
                .discountAmount(1000L)
                .discountRate(null)
                .promotionStartDate(LocalDate.of(2022, 5, 11))
                .promotionEndDate(LocalDate.of(2022, 7, 1))
                .build();
    }
}
