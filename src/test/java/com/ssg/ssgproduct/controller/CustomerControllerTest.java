package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.customer.Customer;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerDeleteRequestDto;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerPostRequestDto;
import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.exception.ResponseCode;
import com.ssg.ssgproduct.service.CustomerService;
import com.ssg.ssgproduct.util.CustomResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.ssg.ssgproduct.util.EntityCreator.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    @DisplayName("Controller - 유저 조회")
    public void customerGet() throws Exception {
        // given
        Customer c = createCustomer();
        given(customerService.find(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, c.convertToResponseDto())
        );

        // when
        // then
        mockMvc.perform(get("/customer?customerId=1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Controller - 구매 가능 상품목록 조회")
    public void customerAvailProductGet() throws Exception {
        // given
        Customer c = createCustomer();
        List<Product> productList = List.of(createProduct(), createProduct());
        given(customerService.findAllAvailProduct(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, productList.stream().map(Product::convertToResponseDto))
        );

        // when
        // then
        mockMvc.perform(get("/customer/availProducts?customerId=1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Controller - 유저 생성")
    public void customerPost() throws Exception {
        // given
        Customer c = createCustomer();
        CustomerPostRequestDto dto = createCustomerPostRequestDto();
        given(customerService.save(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, c.convertToResponseDto())
        );

        // when
        // then
        mockMvc.perform(post("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJSONString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Controller - 유저 삭제")
    public void customerDelete() throws Exception {
        // given
        CustomerDeleteRequestDto dto = createCustomerDeleteRequestDto();
        given(customerService.delete(any())).willReturn(
                CustomResponse.create(ResponseCode.OK, dto)
        );

        // when
        // then
        mockMvc.perform(delete("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJSONString(dto)))
                .andExpect(status().isOk());
    }
}