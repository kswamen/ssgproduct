package com.ssg.ssgproduct.domain.product.dtos;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import com.ssg.ssgproduct.util.CustomLocalDateConverter;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductPostRequestDto {
    private String productName;
    private String productType;
    private Long productPrice;
    private String productDisplayStartDate;
    private String productDisplayEndDate;

    private ProductType convertedItemType;
    private LocalDate convertedItemDisplayStartDate;
    private LocalDate convertedItemDisplayEndDate;

    public void convert() {
        convertedItemType = ProductType.nameOf(productType);
        convertedItemDisplayStartDate = CustomLocalDateConverter.convert(productDisplayStartDate);
        convertedItemDisplayEndDate = CustomLocalDateConverter.convert(productDisplayEndDate);
    }

    public Product toEntity() {
        return Product.builder()
                .productName(productName)
                .productType(convertedItemType)
                .productDisplayStartTime(convertedItemDisplayStartDate)
                .productDisplayEndTime(convertedItemDisplayEndDate)
                .productPrice(productPrice)
                .build();
    }
}
