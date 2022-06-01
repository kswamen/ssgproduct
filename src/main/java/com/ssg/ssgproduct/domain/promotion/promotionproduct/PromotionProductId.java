package com.ssg.ssgproduct.domain.promotion.promotionproduct;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class PromotionProductId implements Serializable {
    private Long promotionId;
}
