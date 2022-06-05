package com.ssg.ssgproduct.domain.promotion.dtos;

import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotionproduct.PromotionProduct;
import com.ssg.ssgproduct.util.CustomLocalDateConverter;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PromotionPostRequestDto {
    private String promotionNm;
    private Long discountAmount;
    private Float discountRate;
    private String promotionStartDate;
    private String promotionEndDate;

    private LocalDate convertedPromotionStartDate;
    private LocalDate convertedPromotionEndDate;

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
