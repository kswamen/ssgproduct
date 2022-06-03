package com.ssg.ssgproduct.repository;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.product.ProductSpecs;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.ssg.ssgproduct.util.EntityCreator.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application-test.properties")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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
    @DisplayName("Repository - 기업회원상품이 아닌 상품 검색")
    public void findAllProduct() {
        // given
        Product product1 = productRepository.save(createProduct(ProductType.ENTERPRISE));
        Product product2 = productRepository.save(createProduct(ProductType.ENTERPRISE));
        Product product3 = productRepository.save(createProduct(ProductType.NORMAL));

        // when
        Specification<Product> spec = (root, query, criteriaBuilder) -> null;
        spec = spec.and(ProductSpecs.withoutProductType(ProductType.ENTERPRISE));
        spec = spec.and(ProductSpecs.withDateCondition());
        List<Product> result = productRepository.findAll(spec);

        // then
        assertThat(result.size(), equalTo(1));
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


}