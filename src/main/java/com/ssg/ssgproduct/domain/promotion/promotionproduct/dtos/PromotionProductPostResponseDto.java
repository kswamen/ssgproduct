package com.ssg.ssgproduct.domain.promotion.promotionproduct.dtos;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PromotionProductPostResponseDto {
    public Promotion promotion;
    public Product product;
}
