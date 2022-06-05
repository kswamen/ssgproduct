package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.customer.dtos.CustomerDeleteRequestDto;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerGetRequestDto;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerPostRequestDto;
import com.ssg.ssgproduct.domain.product.ProductSpecs;
import com.ssg.ssgproduct.service.CustomerService;
import com.ssg.ssgproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer")
@RequiredArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Object> readUser(CustomerGetRequestDto customerGetDto) {
        return customerService.find(customerGetDto);
    }

    @GetMapping("/availProducts")
    public ResponseEntity<Object> readAvailProducts(CustomerGetRequestDto customerGetDto) {
        return customerService.findAllAvailProduct(customerGetDto);
    }


    @PostMapping("")
    public ResponseEntity<Object> createUser(@RequestBody CustomerPostRequestDto customerPostDto) {
        customerPostDto.convert();
        return customerService.save(customerPostDto);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteUser(@RequestBody CustomerDeleteRequestDto customerDeleteDto) {
        return customerService.delete(customerDeleteDto);
    }
}
