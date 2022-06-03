package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductGetRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.PromotionRepository;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionDeleteRequestDto;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionPostRequestDto;
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
import static com.ssg.ssgproduct.util.EntityCreator.createPromotionProduct;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PromotionServiceTest {
    @InjectMocks
    private PromotionService promotionService;

    @Mock
    private PromotionRepository promotionRepository;

    @Test
    @DisplayName("Service - 프로모션 생성")
    public void save() {
        // given
        Promotion promotion = createPromotion();
        when(promotionRepository.save(any())).thenReturn(promotion);

        // when
        PromotionPostRequestDto dto = createPromotionPostRequestDto();
        dto.convert();
        ResponseEntity<Object> result = promotionService.save(dto);

        // then
        verify(promotionRepository, times(1)).save(any());
        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    @DisplayName("Service - 프로모션 삭제")
    public void delete() {
        // given
        PromotionDeleteRequestDto promotionDeleteRequestDto = new PromotionDeleteRequestDto(1L);
        Promotion promotion = createPromotion();
        when(promotionRepository.findById(any())).thenReturn(Optional.ofNullable(promotion));

        // when
        ResponseEntity<Object> result = promotionService.delete(promotionDeleteRequestDto);

        // then
        verify(promotionRepository, times(1)).delete(any());
        assertThat(result, equalTo(CustomResponse.create(ResponseCode.OK, promotionDeleteRequestDto)));
    }

    private PromotionPostRequestDto createPromotionPostRequestDto() {
        return PromotionPostRequestDto.builder()
                .promotionNm("test")
                .promotionStartDate("2022-05-12")
                .promotionEndDate("2030-05-14")
                .discountAmount(3000L)
                .discountRate(0.05f)
                .build();
    }
}