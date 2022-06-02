package com.ssg.ssgproduct.domain.customer;

import com.ssg.ssgproduct.domain.customer.dtos.CustomerPostResponseDto;
import com.ssg.ssgproduct.domain.customer.enums.CustomerStat;
import com.ssg.ssgproduct.domain.customer.enums.CustomerStatConverter;
import com.ssg.ssgproduct.domain.customer.enums.CustomerType;
import com.ssg.ssgproduct.domain.customer.enums.CustomerTypeConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CustomerId;

    @Column
    private String CustomerName;

//    @Enumerated(EnumType.STRING)
    @Convert(converter = CustomerTypeConverter.class)
//    @Column
    private CustomerType CustomerType;

//    @Enumerated(EnumType.STRING)
    @Convert(converter = CustomerStatConverter.class)
//    @Column
    private CustomerStat CustomerStat;

    @Builder
    public Customer(Long customerId, String customerName, CustomerType customerType, CustomerStat customerStat) {
        this.CustomerId = customerId;
        this.CustomerName = customerName;
        this.CustomerType = customerType;
        this.CustomerStat = customerStat;
    }

    public CustomerPostResponseDto convertToResponseDto() {
        return CustomerPostResponseDto.builder()
                .customerId(CustomerId)
                .customerName(CustomerName)
                .customerType(CustomerType.getUserTypeString())
                .customerStat(CustomerStat.getUserStatString()).build();
    }

    public boolean isExited() {
        return com.ssg.ssgproduct.domain.customer.enums.CustomerStat.QUIT.equals(this.CustomerStat);
    }
}
