package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.customer.Customer;
import com.ssg.ssgproduct.domain.customer.CustomerRepository;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerGetRequestDto;
import com.ssg.ssgproduct.domain.customer.enums.CustomerType;
import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.product.ProductSpecs;
import com.ssg.ssgproduct.domain.product.dtos.ProductDeleteRequestDto;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostRequestDto;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import com.ssg.ssgproduct.util.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public ResponseEntity<Object> save(ProductPostRequestDto productPostDto) {
        Product product = productRepository.save(productPostDto.toEntity());
        return CustomResponse.create("OK", HttpStatus.OK, product.convertToResponseDto());
    }

    @Transactional
    public ResponseEntity<Object> delete(ProductDeleteRequestDto productDeleteDto) {
        Product product = productRepository.findById(productDeleteDto.getProductId()).orElseThrow();
        productRepository.delete(product);
        return CustomResponse.create("OK", HttpStatus.OK, productDeleteDto);
    }

    public ResponseEntity<Object> findAllAvailProduct(CustomerGetRequestDto customerGetDto) {
        Customer customer = customerRepository.findById(customerGetDto.customerId).orElseThrow();
        if (customer.isExited()) {
            throw new RuntimeException();
        }
        else {
            Specification<Product> spec = (root, query, criteriaBuilder) -> null;
            spec = spec.and(ProductSpecs.withDateCondition());
            if (customer.getCustomerType().equals(CustomerType.NORMAL)) {
                spec = spec.and(ProductSpecs.withoutProductType(ProductType.ENTERPRISE));
            }

            List<Product> productList = productRepository.findAll(spec);
            return CustomResponse.create("OK", HttpStatus.OK, productList);
        }
    }
}
