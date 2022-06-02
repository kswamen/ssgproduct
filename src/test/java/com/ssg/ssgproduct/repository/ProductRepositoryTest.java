package com.ssg.ssgproduct.repository;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Repository - 상품 생성")
    public void save() {
        // given
        Product product = createProduct();

        // when
        Product result = productRepository.save(product);

        // then
        assertThat(result, equalTo(product));
    }

    @Test
    @DisplayName("Repository - 상품 삭제")
    public void delete() {
        // given
        Product product = createProduct();

        // when
        productRepository.save(product);
        productRepository.delete(product);
        Optional<Product> result = productRepository.findById(product.getProductId());

        // then
        assertThat(result.isEmpty(), equalTo(true));
    }

    private Product createProduct() {
        return Product.builder()
                .productName("노브랜드 버터링")
                .productType(ProductType.ENTERPRISE)
                .productPrice(20000L)
                .productDisplayStartTime(LocalDate.of(2022, 1, 1))
                .productDisplayEndTime(LocalDate.of(2023, 1, 1))
                .build();
    }
}