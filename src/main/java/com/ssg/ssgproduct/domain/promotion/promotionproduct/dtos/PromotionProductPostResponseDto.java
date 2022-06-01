package com.ssg.ssgproduct.domain.promotion.promotionproduct.dtos;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PromotionProductPostResponseDto {
    public Long promotionId;
    public String itemId;
}
