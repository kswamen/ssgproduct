package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.domain.user.dtos.UserGetRequestDto;
import com.ssg.ssgproduct.domain.user.dtos.UserPostRequestDto;
import com.ssg.ssgproduct.service.ProductService;
import com.ssg.ssgproduct.service.UserService;
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