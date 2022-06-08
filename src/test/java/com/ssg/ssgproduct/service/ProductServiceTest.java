package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductGetRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.PromotionRepository;
import com.ssg.ssgproduct.exception.ResponseCode;
import com.ssg.ssgproduct.util.CustomResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.ssg.ssgproduct.util.EntityCreator.createPromotion;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private PromotionRepository promotionRepository;

    @Test
    @DisplayName("Service - 상품 생성")
    public void save() {
        // given
        Product product = createProduct();
        when(productRepository.save(any())).thenReturn(product);

        // when
        ProductPostRequestDto dto = createPostDto();
        dto.convert();
        ResponseEntity<Object> result = productService.save(dto);

        // then
        verify(productRepository, times(1)).save(any());
        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    @DisplayName("Service - 상품 삭제")
    public void delete() {
        // given
        ProductDeleteRequestDto productDeleteRequestDto = new ProductDeleteRequestDto(1L);
        Product product = createProduct();
        when(productRepository.findById(any())).thenReturn(Optional.ofNullable(product));

        // when
        ResponseEntity<Object> result = productService.delete(productDeleteRequestDto);

        // then
        verify(productRepository, times(1)).delete(any());
        assertThat(result, equalTo(CustomResponse.create(ResponseCode.OK, productDeleteRequestDto)));
    }

    @Test
    @DisplayName("Service - 상품과 연관된 최저가 프로모션 조회")
    public void findRelatedPromotion() {
        // given
        Product product = createProduct();
        List<Promotion> promotionList = List.of(createPromotion(), createPromotion(), createPromotion());
        when(productRepository.findById(any())).thenReturn(Optional.ofNullable(product));
        when(promotionRepository.findAllByRelatedProductId(any(), any())).thenReturn(promotionList);
        ProductGetRequestDto productGetRequestDto = new ProductGetRequestDto(1L);

        // when
        ResponseEntity<Object> result = productService.findRelatedPromotion(productGetRequestDto);

        // then
        verify(productRepository, times(1)).findById(any());
        verify(promotionRepository, times(1)).findAllByRelatedProductId(any(), any());
        assertThat(result.getStatusCode(), equalTo(ResponseCode.OK.getStatus()));
    }

    private Product createProduct() {
        return Product.builder()
                .productName("노브랜드 버터링")
                .productType(ProductType.ENTERPRISE)
                .productPrice(20000L)
                .productDisplayStartTime(LocalDate.of(2022, 1, 1))
                .productDisplayEndTime(LocalDate.of(2099, 6, 2))
                .build();
    }

    private ProductPostRequestDto createPostDto() {
        return ProductPostRequestDto.builder()
                .productName("test")
                .productPrice(2000L)
                .productType("일반")
                .productDisplayStartDate("2022-05-20")
                .productDisplayEndDate("2039-04-14")
                .build();
    }
}