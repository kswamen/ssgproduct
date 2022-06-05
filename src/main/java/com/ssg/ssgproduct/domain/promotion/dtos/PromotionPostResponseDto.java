package com.ssg.ssgproduct.domain.promotion.dtos;

import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.util.CustomLocalDateConverter;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PromotionPostResponseDto {
    private String promotionNm;
    private Long discountAmount;
    private Float discountRate;
    private LocalDate promotionStartDate;
    private LocalDate promotionEndDate;
}
