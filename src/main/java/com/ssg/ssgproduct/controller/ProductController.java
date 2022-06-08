package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductGetRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

//    @GetMapping("")
//    public ResponseEntity<Object> readProduct(@RequestBody UserGetRequestDto userGetDto) {
//        return null;
//    }

    @GetMapping("/relatedPromotion")
    public ResponseEntity<Object> findRelatedPromotion(ProductGetRequestDto productGetDto) {
        return productService.findRelatedPromotion(productGetDto);
    }

    @PostMapping("")
    public ResponseEntity<Object> createProduct(@RequestBody ProductPostRequestDto productPostDto) {
        productPostDto.convert();
        return productService.save(productPostDto);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteProduct(@RequestBody ProductDeleteRequestDto productDeleteDto) {
        return productService.delete(productDeleteDto);
    }
}
