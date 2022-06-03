package com.ssg.ssgproduct.repository;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.PromotionRepository;
import com.ssg.ssgproduct.domain.promotionproduct.PromotionProduct;
import com.ssg.ssgproduct.domain.promotionproduct.PromotionProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application-test.properties")
class PromotionRepositoryTest {
    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PromotionProductRepository promotionProductRepository;

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

    @Test
    @DisplayName("Repository - 상품 연관 프로모션 전체 조회")
    public void findAllRelatedPromotion() {
        // given
        Product product1 = productRepository.save(createProduct());
        Product product2 = productRepository.save(createProduct());
        Promotion promotion1 = promotionRepository.save(createPromotion());
        Promotion promotion2 = promotionRepository.save(createPromotion());
        promotionProductRepository.save(PromotionProduct.builder().promotion(promotion1).product(product1).build());
        promotionProductRepository.save(PromotionProduct.builder().promotion(promotion2).product(product1).build());
        promotionProductRepository.save(PromotionProduct.builder().promotion(promotion1).product(product2).build());
        promotionProductRepository.save(PromotionProduct.builder().promotion(promotion2).product(product2).build());

        // when
        List<Promotion> promotions = promotionRepository.findAllByRelatedProductId(
                product1.getProductId(), LocalDate.now());

        // then
        assertThat(promotions.size(), equalTo(2));
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

    private Product createProduct() {
        return Product.builder()
                .productName("노브랜드 버터링")
                .productType(ProductType.NORMAL)
                .productPrice(20000L)
                .productDisplayStartTime(LocalDate.of(2022, 1, 1))
                .productDisplayEndTime(LocalDate.of(2099, 6, 2))
                .build();
    }

    private PromotionProduct createPromotionProduct() {
        return PromotionProduct.builder()
                .product(createProduct())
                .promotion(createPromotion())
                .build();
    }
}