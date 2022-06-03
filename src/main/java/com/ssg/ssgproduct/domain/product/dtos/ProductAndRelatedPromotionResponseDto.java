package com.ssg.ssgproduct.domain.product.dtos;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductAndRelatedPromotionResponseDto {
    public String appliedDiscountType;
    public Map<String, Long> price;
    public Product product;
    public Promotion promotion;
}
