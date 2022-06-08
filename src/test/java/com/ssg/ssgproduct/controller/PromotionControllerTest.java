package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductGetRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionGetRequestDto;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionPostRequestDto;
import com.ssg.ssgproduct.exception.ResponseCode;
import com.ssg.ssgproduct.service.ProductService;
import com.ssg.ssgproduct.service.PromotionService;
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

class PromotionControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    private PromotionController promotionController;

    @Mock
    private PromotionService promotionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(promotionController).build();
    }

    @Test
    @DisplayName("Controller - 프로모션 조회")
    public void promotionGet() throws Exception {
        // given
        Promotion p = createPromotion();
        PromotionGetRequestDto dto = createPromotionGetRequestDto();
        given(promotionService.find(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, p.convertToResponseDto())
        );

        // when
        // then
        mockMvc.perform(get("/promotion?promotionId=1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Controller - 프로모션 생성")
    public void promotionPost() throws Exception {
        // given
        Promotion p = createPromotion();
        PromotionPostRequestDto dto = createPromotionPostRequestDto();
        given(promotionService.save(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, p.convertToResponseDto())
        );

        // when
        // then
        mockMvc.perform(post("/promotion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJSONString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Controller - 프로모션 삭제")
    public void promotionDelete() throws Exception {
        // given
        PromotionGetRequestDto dto = createPromotionGetRequestDto();
        given(promotionService.delete(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, dto)
        );

        // when
        // then
        mockMvc.perform(delete("/promotion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJSONString(dto)))
                .andExpect(status().isOk());
    }
}