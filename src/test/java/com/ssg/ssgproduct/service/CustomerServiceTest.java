package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.customer.Customer;
import com.ssg.ssgproduct.domain.customer.CustomerRepository;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerDeleteRequestDto;
import com.ssg.ssgproduct.domain.customer.dtos.CustomerPostRequestDto;
import com.ssg.ssgproduct.domain.customer.enums.CustomerStat;
import com.ssg.ssgproduct.domain.customer.enums.CustomerType;
import com.ssg.ssgproduct.util.CustomResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Service - 유저 생성")
    public void save() {
        // given
        Customer user = createUser();
        when(customerRepository.save(any())).thenReturn(user);

        // when
        ResponseEntity<Object> result = customerService.save(createUserDto());

        // then
        verify(customerRepository, times(1)).save(any());
        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    @DisplayName("Service - 유저 삭제")
    public void delete() {
        // given
        CustomerDeleteRequestDto customerDeleteRequestDto = new CustomerDeleteRequestDto(1L);
        Customer user = createUser();
        when(customerRepository.findById(any())).thenReturn(Optional.ofNullable(user));

        // when
        ResponseEntity<Object> result = customerService.delete(customerDeleteRequestDto);

        // then
        verify(customerRepository, times(1)).delete(any());
        assertThat(result, equalTo(CustomResponse.create("OK", HttpStatus.OK, customerDeleteRequestDto)));
    }


    private Customer createUser() {
        return Customer.builder()
//                .userId(1L)
                .customerName("김석원")
                .customerStat(CustomerStat.NORMAL)
                .customerType(CustomerType.NORMAL)
                .build();
    }

    private CustomerPostRequestDto createUserDto() {
        return CustomerPostRequestDto.builder()
                .customerName("김석원")
                .customerType("일반")
                .customerStat("정상")
                .build();
    }
}