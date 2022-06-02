package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.promotion.dtos.PromotionDeleteRequestDto;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionGetRequestDto;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionPostRequestDto;
import com.ssg.ssgproduct.domain.promotion.promotionproduct.PromotionProduct;
import com.ssg.ssgproduct.domain.promotion.promotionproduct.dtos.PromotionProductPostRequestDto;
import com.ssg.ssgproduct.service.PromotionProductService;
import com.ssg.ssgproduct.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/promotionproduct")
@RequiredArgsConstructor
@RestController
public class PromotionProductController {
    private final PromotionProductService promotionProductService;

    @PostMapping("")
    public ResponseEntity<Object> updatePromotionProduct(
            @RequestBody PromotionProductPostRequestDto promotionProductPostDto) {
        return promotionProductService.save(promotionProductPostDto);
    }
}
