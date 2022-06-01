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
    public String promotionNm;
    public Long discountAmount;
    public Float discountRate;
    public LocalDate promotionStartDate;
    public LocalDate promotionEndDate;
}
