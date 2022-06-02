package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.domain.user.User;
import com.ssg.ssgproduct.domain.user.UserRepository;
import com.ssg.ssgproduct.domain.user.dtos.UserDeleteRequestDto;
import com.ssg.ssgproduct.domain.user.dtos.UserGetRequestDto;
import com.ssg.ssgproduct.domain.user.dtos.UserPostRequestDto;
import com.ssg.ssgproduct.util.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ResponseEntity<Object> save(ProductPostRequestDto productPostDto) {
        Product product = productRepository.save(productPostDto.toEntity());
        return CustomResponse.create("OK", HttpStatus.OK, product.convertToResponseDto());
    }

    public ResponseEntity<Object> delete(ProductDeleteRequestDto productDeleteDto) {
        Product product = productRepository.findById(productDeleteDto.getProductId()).orElseThrow();
        productRepository.delete(product);
        return CustomResponse.create("OK", HttpStatus.OK, productDeleteDto);
    }
}
