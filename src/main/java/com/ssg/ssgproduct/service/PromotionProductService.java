package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.PromotionRepository;
import com.ssg.ssgproduct.domain.promotion.promotionproduct.PromotionProduct;
import com.ssg.ssgproduct.domain.promotion.promotionproduct.PromotionProductRepository;
import com.ssg.ssgproduct.domain.promotion.promotionproduct.dtos.PromotionProductPostRequestDto;
import com.ssg.ssgproduct.domain.promotion.promotionproduct.dtos.PromotionProductPostResponseDto;
import com.ssg.ssgproduct.util.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PromotionProductService {
    private final PromotionProductRepository promotionProductRepository;
    private final PromotionRepository promotionRepository;
    private final ProductRepository productRepository;

    // 프로모션 연관 상품 저장 및 업데이트
    @Transactional
    public ResponseEntity<Object> save(PromotionProductPostRequestDto promotionProductPostDto) {
        Promotion promotion = promotionRepository.findById(promotionProductPostDto.getPromotionId()).orElseThrow();
        Product product = productRepository.findById(promotionProductPostDto.getProductId()).orElseThrow();
        promotionProductRepository.save(PromotionProduct.builder()
                .promotion(promotion)
                .product(product)
                .build());

        return CustomResponse.create("OK", HttpStatus.OK,
                PromotionProductPostResponseDto.builder()
                        .promotion(promotion).product(product).build()
        );
    }
}
