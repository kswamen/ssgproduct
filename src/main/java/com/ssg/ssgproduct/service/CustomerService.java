package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.customer.*;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerDeleteRequestDto;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerGetRequestDto;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerPostRequestDto;
import com.ssg.ssgproduct.util.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public ResponseEntity<Object> save(CustomerPostRequestDto customerPostDto) {
        Customer customer = customerRepository.save(customerPostDto.toEntity());
        return CustomResponse.create("OK", HttpStatus.OK, customer.convertToResponseDto());
    }

    @Transactional
    public ResponseEntity<Object> delete(CustomerDeleteRequestDto customerDeleteDto) {
        Customer customer = customerRepository.findById(customerDeleteDto.getCustomerId()).orElseThrow();
        customerRepository.delete(customer);
        return CustomResponse.create("OK", HttpStatus.OK, customerDeleteDto);
    }

    public ResponseEntity<Object> find(CustomerGetRequestDto customerGetDto) {
        Customer customer = customerRepository.findById(customerGetDto.getCustomerId()).orElseThrow();
        return CustomResponse.create("OK", HttpStatus.OK, customer.convertToResponseDto());
    }
}
