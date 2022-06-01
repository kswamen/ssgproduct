package com.ssg.ssgproduct.domain.promotion.dtos;

import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.promotionproduct.PromotionProduct;
import com.ssg.ssgproduct.util.CustomLocalDateConverter;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PromotionPostRequestDto {
    public String promotionNm;
    public Long discountAmount;
    public Float discountRate;
    public String promotionStartDate;
    public String promotionEndDate;

    public LocalDate convertedPromotionStartDate;
    public LocalDate convertedPromotionEndDate;

    public void convert() {
        convertedPromotionStartDate = CustomLocalDateConverter.convert(promotionStartDate);
        convertedPromotionEndDate = CustomLocalDateConverter.convert(promotionEndDate);
    }

    public Promotion toEntity() {
        return Promotion.builder()
                .promotionNm(promotionNm)
                .discountAmount(discountAmount)
                .discountRate(discountRate)
                .promotionStartDate(convertedPromotionStartDate)
                .promotionEndDate(convertedPromotionEndDate)
                .promotionProduct(new PromotionProduct())
                .build();
    }
}
