package com.ssg.ssgproduct.domain.customer.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPostResponseDto {
    private Long customerId;
    private String customerName;
    private String customerType;
    private String customerStat;
}
