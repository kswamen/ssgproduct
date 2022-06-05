package com.ssg.ssgproduct.domain.product.dtos;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPostResponseDto {
    private Long productId;
    private String productName;
    private String productType;
    private Long productPrice;
    private LocalDate productDisplayStartDate;
    private LocalDate productDisplayEndDate;
}
