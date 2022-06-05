package com.ssg.ssgproduct.domain.promotionproduct.dtos;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PromotionProductPostResponseDto {
    private Promotion promotion;
    private Product product;
}
