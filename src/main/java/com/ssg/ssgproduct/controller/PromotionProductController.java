package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.promotionproduct.dtos.PromotionProductPostRequestDto;
import com.ssg.ssgproduct.service.PromotionProductService;
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
