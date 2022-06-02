package com.ssg.ssgproduct.domain.promotionproduct.dtos;

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
