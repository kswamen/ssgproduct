package com.ssg.ssgproduct.repository;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.PromotionRepository;
import com.ssg.ssgproduct.domain.promotionproduct.PromotionProduct;
import com.ssg.ssgproduct.domain.promotionproduct.PromotionProductId;
import com.ssg.ssgproduct.domain.promotionproduct.PromotionProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static com.ssg.ssgproduct.util.EntityCreator.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application-test.properties")
class PromotionProductRepositoryTest {
    @Autowired
    private PromotionProductRepository promotionProductRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Repository - 프로모션-상품 생성")
    public void save() {
        // given
        Promotion promotion = promotionRepository.save(createPromotion());
        Product product = productRepository.save(createProduct());
        PromotionProduct promotionProduct = PromotionProduct.builder()
                .product(product)
                .promotion(promotion)
                .build();

        // when
        PromotionProduct result = promotionProductRepository.save(promotionProduct);

        // then
        assertThat(result.getProduct(), equalTo(product));
        assertThat(result.getPromotion(), equalTo(promotion));
    }

    @Test
    @DisplayName("Repository - 프로모션-상품 삭제")
    public void delete() {
        // given
        Promotion promotion = promotionRepository.save(createPromotion());
        Product product = productRepository.save(createProduct());
        PromotionProduct promotionProduct = PromotionProduct.builder()
                .product(product)
                .promotion(promotion)
                .build();

        // when
        promotionProductRepository.save(promotionProduct);
        promotionProductRepository.delete(promotionProduct);
        Optional<PromotionProduct> result = promotionProductRepository.findById(
                new PromotionProductId(
                        promotionProduct.getPromotion().getPromotionId(),
                        promotionProduct.getProduct().getProductId())
        );

        // then
        assertThat(result.isEmpty(), equalTo(true));
    }
}