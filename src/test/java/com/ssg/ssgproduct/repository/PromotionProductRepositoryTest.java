package com.ssg.ssgproduct.repository;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
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

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PromotionProductRepositoryTest {
    @Autowired
    private PromotionProductRepository promotionProductRepository;

    @Test
    @DisplayName("Repository - 상품 생성")
    public void save() {
        // given
        PromotionProduct promotionProduct = createPromotionProduct();

        // when
        PromotionProduct result = promotionProductRepository.save(promotionProduct);

        // then
        assertThat(result == null, equalTo(false));
    }

    @Test
    @DisplayName("Repository - 상품 삭제")
    public void delete() {
        // given
        PromotionProduct promotionProduct = createPromotionProduct();

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

    private Promotion createPromotion() {
        return Promotion.builder()
                .promotionId(1L)
                .promotionNm("2022 쓱데이")
                .discountAmount(1000L)
                .discountRate(null)
                .promotionStartDate(LocalDate.of(2022, 5, 11))
                .promotionEndDate(LocalDate.of(2022, 7, 1))
                .build();
    }

    private Product createProduct() {
        return Product.builder()
                .productId(1L)
                .productName("노브랜드 버터링")
                .productType(ProductType.ENTERPRISE)
                .productPrice(20000L)
                .productDisplayStartTime(LocalDate.of(2022, 1, 1))
                .productDisplayEndTime(LocalDate.of(2023, 1, 1))
                .build();
    }

    private PromotionProduct createPromotionProduct() {
        return PromotionProduct.builder()
                .product(createProduct())
                .promotion(createPromotion())
                .build();
    }
}