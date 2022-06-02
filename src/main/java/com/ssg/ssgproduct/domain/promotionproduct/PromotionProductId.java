package com.ssg.ssgproduct.domain.promotionproduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionProductId implements Serializable {
    private Long promotion;
    private Long product;
}
