package com.ssg.ssgproduct.domain.product.dtos;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.enums.ItemType;
import com.ssg.ssgproduct.util.CustomLocalDateConverter;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDeleteRequestDto {
    public Long itemId;
}
