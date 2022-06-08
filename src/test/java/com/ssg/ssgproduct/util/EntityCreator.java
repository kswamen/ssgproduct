package com.ssg.ssgproduct.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssg.ssgproduct.domain.customer.Customer;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerDeleteRequestDto;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerPostRequestDto;
import com.ssg.ssgproduct.domain.customer.enums.CustomerStat;
import com.ssg.ssgproduct.domain.customer.enums.CustomerType;
import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductGetRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionGetRequestDto;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionPostRequestDto;
import com.ssg.ssgproduct.domain.promotionproduct.PromotionProduct;
import com.ssg.ssgproduct.domain.promotionproduct.dtos.PromotionProductPostRequestDto;
import com.ssg.ssgproduct.domain.promotionproduct.dtos.PromotionProductPostResponseDto;

import java.time.LocalDate;

public class EntityCreator {
    public static Customer createCustomer() {
        return Customer.builder()
//                .userId(1L)
                .customerName("김석원")
                .customerStat(CustomerStat.NORMAL)
                .customerType(CustomerType.NORMAL)
                .build();
    }

    public static Customer createCustomer(CustomerStat stat, CustomerType type) {
        return Customer.builder()
//                .userId(1L)
                .customerName("김석원")
                .customerStat(stat)
                .customerType(type)
                .build();
    }

    public static CustomerPostRequestDto createCustomerPostRequestDto() {
        return CustomerPostRequestDto.builder()
                .customerName("John")
                .customerStat("정상")
                .customerType("일반")
                .build();
    }

    public static CustomerDeleteRequestDto createCustomerDeleteRequestDto() {
        return new CustomerDeleteRequestDto(1L);
    }

    public static String asJSONString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public static ProductPostRequestDto createProductPostRequestDto() {
        return ProductPostRequestDto.builder()
                .productName("Test Product")
                .productPrice(20000L)
                .productType("일반")
                .productDisplayStartDate("2022-01-01")
                .productDisplayEndDate("2099-01-01")
                .build();
    }

    public static ProductGetRequestDto createProductGetRequestDto() {
        return new ProductGetRequestDto(1L);
    }

    public static ProductDeleteRequestDto createProductDeleteRequestDto() {
        return new ProductDeleteRequestDto(1L);
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

    public static PromotionGetRequestDto createPromotionGetRequestDto() {
        return new PromotionGetRequestDto(1L);
    }

    public static PromotionPostRequestDto createPromotionPostRequestDto() {
        return PromotionPostRequestDto.builder()
                .promotionNm("Test Promotion Name")
                .discountAmount(1000L)
                .discountRate(0.05f)
                .promotionStartDate("2022-01-01")
                .promotionEndDate("2099-01-01")
                .build();
    }

    public static PromotionProductPostRequestDto createPromotionProductPostRequestDto() {
        return new PromotionProductPostRequestDto(1L, 1L);
    }

    public static PromotionProductPostResponseDto createPromotionProductPostResponseDto() {
        return PromotionProductPostResponseDto.builder()
                .product(createProduct())
                .promotion(createPromotion())
                .build();
    }
}
