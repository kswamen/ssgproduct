package com.ssg.ssgproduct.domain.customer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerGetRequestDto {
    public Long customerId;
}
