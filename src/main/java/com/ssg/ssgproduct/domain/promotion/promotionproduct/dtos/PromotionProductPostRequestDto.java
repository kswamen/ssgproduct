package com.ssg.ssgproduct.domain.promotion.promotionproduct.dtos;

import com.ssg.ssgproduct.domain.promotion.promotionproduct.PromotionProduct;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PromotionProductPostRequestDto {
    public Long promotionId;
    public Long productId;
}
