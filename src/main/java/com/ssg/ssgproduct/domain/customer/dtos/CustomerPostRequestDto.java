package com.ssg.ssgproduct.domain.customer.dtos;

import com.ssg.ssgproduct.domain.customer.Customer;
import com.ssg.ssgproduct.domain.customer.enums.CustomerStat;
import com.ssg.ssgproduct.domain.customer.enums.CustomerType;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerPostRequestDto {
    public String customerName;
    public String customerType;
    public String customerStat;

    public CustomerType convertedCustomerType;
    public CustomerStat convertedCustomerStat;

    public void convert() {
        convertedCustomerType = CustomerType.nameOf(customerType);
        convertedCustomerStat = CustomerStat.nameOf(customerStat);
    }

    public Customer toEntity() {
//        convert();
        return Customer.builder()
                .customerName(customerName)
                .customerType(convertedCustomerType)
                .customerStat(convertedCustomerStat)
                .build();
    }
}
