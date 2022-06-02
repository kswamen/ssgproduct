package com.ssg.ssgproduct.domain.product.dtos;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPostResponseDto {
    public Long productId;
    public String productName;
    public String productType;
    public Long productPrice;
    public LocalDate productDisplayStartDate;
    public LocalDate productDisplayEndDate;
}
