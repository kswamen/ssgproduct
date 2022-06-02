package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.domain.promotion.PromotionRepository;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionDeleteRequestDto;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionGetRequestDto;
import com.ssg.ssgproduct.domain.promotion.dtos.PromotionPostRequestDto;
import com.ssg.ssgproduct.domain.promotion.promotionproduct.dtos.PromotionProductPostRequestDto;
import com.ssg.ssgproduct.domain.user.dtos.UserGetRequestDto;
import com.ssg.ssgproduct.service.ProductService;
import com.ssg.ssgproduct.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/promotion")
@RequiredArgsConstructor
@RestController
public class PromotionController {
    private final PromotionService promotionService;

    @GetMapping("")
    public ResponseEntity<Object> readPromotion(@RequestBody PromotionGetRequestDto promotionGetDto) {
        return promotionService.find(promotionGetDto);
    }

    @PostMapping("")
    public ResponseEntity<Object> createPromotion(@RequestBody PromotionPostRequestDto promotionPostDto) {
        promotionPostDto.convert();
        return promotionService.save(promotionPostDto);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deletePromotion(@RequestBody PromotionDeleteRequestDto promotionDeleteDto) {
        return promotionService.delete(promotionDeleteDto);
    }
}
