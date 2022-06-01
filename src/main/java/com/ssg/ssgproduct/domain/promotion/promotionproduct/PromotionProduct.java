package com.ssg.ssgproduct.domain.promotion.promotionproduct;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PromotionProduct {
    @Id
    private Long promotionProductId;

    @Column
    private String ItemId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "PromotionId")
    @JsonIgnore
    private Promotion promotion;

    public void updateItemId(String itemId) {
        this.ItemId = itemId;
    }

    public PromotionProduct(String itemId) {
        this.ItemId = itemId;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
