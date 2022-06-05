package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.customer.*;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerDeleteRequestDto;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerGetRequestDto;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerPostRequestDto;
import com.ssg.ssgproduct.domain.customer.enums.CustomerType;
import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.ProductRepository;
import com.ssg.ssgproduct.domain.product.ProductSpecs;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import com.ssg.ssgproduct.exception.ResponseCode;
import com.ssg.ssgproduct.exception.exceptioncase.CustomerNotFoundException;
import com.ssg.ssgproduct.exception.exceptioncase.ExitedCustomerException;
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
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Transactional
    public ResponseEntity<Object> save(CustomerPostRequestDto customerPostDto) {
        Customer customer = customerRepository.save(customerPostDto.toEntity());
        return CustomResponse.create(ResponseCode.OK, customer.convertToResponseDto());
    }

    @Transactional
    public ResponseEntity<Object> delete(CustomerDeleteRequestDto customerDeleteDto) {
        Customer customer = customerRepository.findById(customerDeleteDto.getCustomerId()).orElseThrow(
                () -> new CustomerNotFoundException(ResponseCode.CUSTOMER_NOT_FOUND)
        );
        customerRepository.delete(customer);
        return CustomResponse.create(ResponseCode.OK, customerDeleteDto);
    }

    public ResponseEntity<Object> find(CustomerGetRequestDto customerGetDto) {
        Customer customer = customerRepository.findById(customerGetDto.getCustomerId()).orElseThrow(
                () -> new CustomerNotFoundException(ResponseCode.CUSTOMER_NOT_FOUND)
        );
        return CustomResponse.create(ResponseCode.OK, customer.convertToResponseDto());
    }

    // 소비자가 구매할 수 있는 상품 목록
    // 일반 소비자는 기업상품을 조회할 수 없음
    public ResponseEntity<Object> findAllAvailProduct(CustomerGetRequestDto customerGetDto) {
        Customer customer = customerRepository.findById(customerGetDto.getCustomerId()).orElseThrow(
                () -> new CustomerNotFoundException(ResponseCode.CUSTOMER_NOT_FOUND)
        );
        if (customer.isExited()) {
            throw new ExitedCustomerException(ResponseCode.EXITED_CUSTOMER);
        }
        else {
            Specification<Product> spec = (root, query, criteriaBuilder) -> null;
            spec = spec.and(ProductSpecs.withDateCondition());
            if (customer.getCustomerType().equals(CustomerType.NORMAL)) {
                spec = spec.and(ProductSpecs.withoutProductType(ProductType.ENTERPRISE));
            }

            List<Product> productList = productRepository.findAll(spec);
            return CustomResponse.create(ResponseCode.OK, productList);
        }
    }
}
