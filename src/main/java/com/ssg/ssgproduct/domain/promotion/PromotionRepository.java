package com.ssg.ssgproduct.domain.promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    @Query("select p from Promotion p join p.promotionProducts pp where pp.product.ProductId = :productId " +
            "and :today between p.PromotionStartDate and p.PromotionEndDate")
    List<Promotion> findAllByRelatedProductId(@Param("productId") Long productId, @Param("today")LocalDate today);
}