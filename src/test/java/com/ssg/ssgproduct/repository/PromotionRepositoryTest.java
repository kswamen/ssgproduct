package com.ssg.ssgproduct.repository;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.PromotionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application-test.properties")
class PromotionRepositoryTest {
    @Autowired
    private PromotionRepository promotionRepository;

    @Test
    @DisplayName("Repository - 프로모션 생성")
    public void save() {
        // given
        Promotion promotion = createPromotion();

        // when
        Promotion result = promotionRepository.save(promotion);

        // then
        assertThat(result, equalTo(promotion));
    }

    @Test
    @DisplayName("Repository - 프로모션 삭제")
    public void delete() {
        // given
        Promotion promotion = createPromotion();

        // when
        promotionRepository.save(promotion);
        promotionRepository.delete(promotion);
        Optional<Promotion> result = promotionRepository.findById(promotion.getPromotionId());

        // then
        assertThat(result.isEmpty(), equalTo(true));
    }

    private Promotion createPromotion() {
        return Promotion.builder()
                .promotionNm("2022 쓱데이")
                .discountAmount(1000L)
                .discountRate(null)
                .promotionStartDate(LocalDate.of(2022, 5, 11))
                .promotionEndDate(LocalDate.of(2022, 7, 1))
                .build();
    }
}