package com.ssg.ssgproduct.domain.promotion.dtos;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PromotionDeleteRequestDto {
    public Long promotionId;
}
