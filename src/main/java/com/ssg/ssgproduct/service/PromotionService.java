package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.product.dtos.ProductGetRequestDto;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.PromotionRepository;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionDeleteRequestDto;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionGetRequestDto;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionPostRequestDto;
import com.ssg.ssgproduct.exception.ResponseCode;
import com.ssg.ssgproduct.exception.exceptioncase.PromotionNotFoundException;
import com.ssg.ssgproduct.util.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {
    private final PromotionRepository promotionRepository;

    public ResponseEntity<Object> find(PromotionGetRequestDto promotionGetDto) {
        Promotion promotion = promotionRepository.findById(promotionGetDto.getPromotionId()).orElseThrow(
                () -> new PromotionNotFoundException(ResponseCode.PROMOTION_NOT_FOUND)
        );
        return CustomResponse.create(ResponseCode.OK, promotion.convertToResponseDto());
    }

    @Transactional
    public ResponseEntity<Object> save(PromotionPostRequestDto promotionPostDto) {
        Promotion promotion = promotionRepository.save(promotionPostDto.toEntity());
        return CustomResponse.create(ResponseCode.OK, promotion.convertToResponseDto());
    }

    @Transactional
    public ResponseEntity<Object> delete(PromotionDeleteRequestDto promotionDeleteDto) {
        Promotion promotion = promotionRepository.findById(promotionDeleteDto.getPromotionId()).orElseThrow(
                () -> new PromotionNotFoundException(ResponseCode.PROMOTION_NOT_FOUND)
        );
        promotionRepository.delete(promotion);
        return CustomResponse.create(ResponseCode.OK, promotionDeleteDto);
    }
}
