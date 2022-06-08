package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.promotionproduct.dtos.PromotionProductPostRequestDto;
import com.ssg.ssgproduct.exception.ResponseCode;
import com.ssg.ssgproduct.service.PromotionProductService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PromotionProductControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    private PromotionProductController promotionProductController;

    @Mock
    private PromotionProductService promotionProductService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(promotionProductController).build();
    }

    @Test
    @DisplayName("Controller - 상품에 프로모션 적용")
    public void promotionPost() throws Exception {
        // given
        PromotionProductPostRequestDto dto = createPromotionProductPostRequestDto();
        given(promotionProductService.save(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, createPromotionProductPostResponseDto())
        );

        // when
        // then
        mockMvc.perform(post("/promotionproduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJSONString(dto)))
                .andExpect(status().isOk());
    }
}