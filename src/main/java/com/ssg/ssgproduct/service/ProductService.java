package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.product.dtos.ProductAndRelatedPromotionResponseDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductGetRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.domain.product.enums.DiscountType;
import com.ssg.ssgproduct.domain.promotion.Promotion;
import com.ssg.ssgproduct.domain.promotion.PromotionRepository;
import com.ssg.ssgproduct.exception.ResponseCode;
import com.ssg.ssgproduct.exception.exceptioncase.NoAvailPromotionException;
import com.ssg.ssgproduct.exception.exceptioncase.ProductNotFoundException;
import com.ssg.ssgproduct.util.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final PromotionRepository promotionRepository;

    @Transactional
    public ResponseEntity<Object> save(ProductPostRequestDto productPostDto) {
        Product product = productRepository.save(productPostDto.toEntity());
        return CustomResponse.create(ResponseCode.OK, product.convertToResponseDto());
    }

    @Transactional
    public ResponseEntity<Object> delete(ProductDeleteRequestDto productDeleteDto) {
        Product product = productRepository.findById(productDeleteDto.getProductId()).orElseThrow(
                () -> new ProductNotFoundException(ResponseCode.PRODUCT_NOT_FOUND)
        );
        productRepository.delete(product);
        return CustomResponse.create(ResponseCode.OK, productDeleteDto);
    }

    public ResponseEntity<Object> findRelatedPromotion(ProductGetRequestDto productGetDto) {
        Product product = productRepository.findById(productGetDto.getProductId()).orElseThrow(
                () -> new ProductNotFoundException(ResponseCode.PRODUCT_NOT_FOUND)
        );
        List<Promotion> promotionList = promotionRepository.findAllByRelatedProductId(
                productGetDto.getProductId(), LocalDate.now());

        return CustomResponse.create(ResponseCode.OK, findBestFitPromotion(promotionList, product));
    }

    // ?????? ?????? ??? ?????? ????????? ????????? ???????????? ??????
    // ??? Dto ??????
    private ProductAndRelatedPromotionResponseDto findBestFitPromotion(List<Promotion> promotionList, Product product) {
        long originalPrice = product.getProductPrice();
        long discountedPrice = Long.MAX_VALUE;
        Promotion selectedPromotion = null;
        DiscountType discountType = null;

        for (Promotion promotion : promotionList) {
            if (promotion.getDiscountAmount() != null) {
                long tempPrice = originalPrice - promotion.getDiscountAmount();
                if (tempPrice > 0 && tempPrice < discountedPrice) {
                    discountedPrice = tempPrice;
                    selectedPromotion = promotion;
                    discountType = DiscountType.AMOUNT;
                }
            }
            if (promotion.getDiscountRate() != null) {
                // 10??? ????????? ???????????? ??????
                long tempPrice = (long) (Math.floor((originalPrice * (1 - promotion.getDiscountRate())) / 10) * 10);
                if (tempPrice > 0 && tempPrice < discountedPrice) {
                    discountedPrice = tempPrice;
                    selectedPromotion = promotion;
                    discountType = DiscountType.RATE;
                }
            }
        }

        // ????????? ??? ?????? ???????????? ??????
        if (discountedPrice == Long.MAX_VALUE) {
            throw new NoAvailPromotionException(ResponseCode.NO_AVAIL_PROMOTION);
        }

        Map<String, Long> price = new HashMap<>();
        price.put("originalPrice", originalPrice);
        price.put("discountedPrice", discountedPrice);

        return ProductAndRelatedPromotionResponseDto.builder()
                .appliedDiscountType(discountType.getDiscountTypeString())
                .price(price)
                .product(product)
                .promotion(selectedPromotion)
                .build();
    }
}
