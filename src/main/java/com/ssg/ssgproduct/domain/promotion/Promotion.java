package com.ssg.ssgproduct.domain.promotion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionPostResponseDto;
import com.ssg.ssgproduct.domain.promotionproduct.PromotionProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
    @JsonIgnore
    private List<PromotionProduct> promotionProducts;

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
