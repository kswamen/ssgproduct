package com.ssg.ssgproduct.domain.promotionproduct.dtos;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PromotionProductPostRequestDto {
    private Long promotionId;
    private Long productId;
}
