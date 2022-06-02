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
    public Long customerId;
    public String customerName;
    public String customerType;
    public String customerStat;
}
