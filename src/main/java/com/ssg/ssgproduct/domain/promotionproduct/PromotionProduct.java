package com.ssg.ssgproduct.domain.promotionproduct;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@IdClass(PromotionProductId.class)
public class PromotionProduct {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "PromotionId")
    private Promotion promotion;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "ItemId")
    private Product product;

    @Builder
    public PromotionProduct(Promotion promotion, Product product) {
        this.promotion = promotion;
        this.product = product;
    }
}
