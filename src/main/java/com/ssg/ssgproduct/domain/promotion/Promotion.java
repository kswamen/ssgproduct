package com.ssg.ssgproduct.domain.promotion;

import com.ssg.ssgproduct.domain.promotion.dtos.PromotionPostResponseDto;
import com.ssg.ssgproduct.domain.promotion.promotionproduct.PromotionProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PromotionId;

    @Column
    private String PromotionNm;

    @Column
    private Long DiscountAmount;

    @Column
    private Float DiscountRate;

    @Column
    private LocalDate PromotionStartDate;

    @Column
    private LocalDate PromotionEndDate;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "promotion")
//    @PrimaryKeyJoinColumn
    private PromotionProduct promotionProduct;

    @Builder
    public Promotion(Long promotionId, String promotionNm, Long discountAmount, Float discountRate,
                     LocalDate promotionStartDate, LocalDate promotionEndDate,
                     PromotionProduct promotionProduct) {
        this.PromotionId = promotionId;
        this.PromotionNm = promotionNm;
        this.DiscountAmount = discountAmount;
        this.DiscountRate = discountRate;
        this.PromotionStartDate = promotionStartDate;
        this.PromotionEndDate = promotionEndDate;
        this.promotionProduct = promotionProduct;
        this.promotionProduct.setPromotion(this);
    }

    public PromotionPostResponseDto convertToResponseDto() {
        return PromotionPostResponseDto.builder()
                .promotionNm(PromotionNm)
                .discountAmount(DiscountAmount)
                .discountRate(DiscountRate)
                .promotionStartDate(PromotionStartDate)
                .promotionEndDate(PromotionEndDate)
                .build();
    }
}
