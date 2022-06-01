package com.ssg.ssgproduct.domain.product.dtos;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.enums.ItemType;
import com.ssg.ssgproduct.util.CustomLocalDateConverter;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPostResponseDto {
    public Long itemId;
    public String itemName;
    public String itemType;
    public Long itemPrice;
    public LocalDate itemDisplayStartDate;
    public LocalDate itemDisplayEndDate;
}
