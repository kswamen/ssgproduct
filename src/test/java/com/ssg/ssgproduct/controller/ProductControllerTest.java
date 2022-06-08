package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductGetRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.exception.ResponseCode;
import com.ssg.ssgproduct.service.ProductService;
import com.ssg.ssgproduct.util.CustomResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.ssg.ssgproduct.util.EntityCreator.*;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    @DisplayName("Controller - 상품 최적 프로모션 반환")
    public void productRelatedPromotion() throws Exception {
        // given
        Promotion p = createPromotion();
        ProductGetRequestDto dto = createProductGetRequestDto();
        given(productService.findRelatedPromotion(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, p.convertToResponseDto())
        );

        // when
        // then
        mockMvc.perform(get("/product/relatedPromotion?productId=1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Controller - 상품 생성")
    public void productPost() throws Exception {
        // given
        Product p = createProduct();
        ProductPostRequestDto dto = createProductPostRequestDto();
        given(productService.save(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, p.convertToResponseDto())
        );

        // when
        // then
        mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJSONString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Controller - 상품 삭제")
    public void productDelete() throws Exception {
        // given
        ProductDeleteRequestDto dto = createProductDeleteRequestDto();
        given(productService.delete(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, dto)
        );

        // when
        // then
        mockMvc.perform(delete("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJSONString(dto)))
                .andExpect(status().isOk());
    }
}