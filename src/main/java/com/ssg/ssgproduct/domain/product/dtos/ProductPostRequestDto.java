package com.ssg.ssgproduct.domain.product.dtos;

import com.ssg.ssgproduct.domain.product.Product;
import com.ssg.ssgproduct.domain.product.enums.ItemType;
import com.ssg.ssgproduct.util.CustomLocalDateConverter;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductPostRequestDto {
    public String itemName;
    public String itemType;
    public Long itemPrice;
    public String itemDisplayStartDate;
    public String itemDisplayEndDate;

    public ItemType convertedItemType;
    public LocalDate convertedItemDisplayStartDate;
    public LocalDate convertedItemDisplayEndDate;

    public void convert() {
        convertedItemType = ItemType.nameOf(itemType);
        convertedItemDisplayStartDate = CustomLocalDateConverter.convert(itemDisplayStartDate);
        convertedItemDisplayEndDate = CustomLocalDateConverter.convert(itemDisplayEndDate);
    }

    public Product toEntity() {
        return Product.builder()
                .itemName(itemName)
                .itemType(convertedItemType)
                .itemDisplayStartTime(convertedItemDisplayStartDate)
                .itemDisplayEndTime(convertedItemDisplayEndDate)
                .itemPrice(itemPrice)
                .build();
    }
}
