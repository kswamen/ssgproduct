package com.ssg.ssgproduct.domain.customer.dtos;

import com.ssg.ssgproduct.domain.customer.Customer;
import com.ssg.ssgproduct.domain.customer.enums.CustomerStat;
import com.ssg.ssgproduct.domain.customer.enums.CustomerType;
import com.ssg.ssgproduct.util.CustomLocalDateConverter;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerPostRequestDto {
    private String customerName;
    private String customerType;
    private String customerStat;

    private CustomerType convertedCustomerType;
    private CustomerStat convertedCustomerStat;

    public void convert() {
        convertedCustomerType = CustomerType.nameOf(customerType);
        convertedCustomerStat = CustomerStat.nameOf(customerStat);
    }

    public Customer toEntity() {
        return Customer.builder()
                .customerName(customerName)
                .customerType(convertedCustomerType)
                .customerStat(convertedCustomerStat)
                .build();
    }
}
