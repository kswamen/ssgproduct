package com.ssg.ssgproduct.domain.product;

import com.ssg.ssgproduct.domain.product.dtos.ProductPostResponseDto;
import com.ssg.ssgproduct.domain.product.enums.ItemType;
import com.ssg.ssgproduct.domain.product.enums.ItemTypeConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ItemId;

    @Column
    private String ItemName;

    @Convert(converter = ItemTypeConverter.class)
    private ItemType ItemType;

    @Column
    private Long ItemPrice;

    @Column
    private LocalDate ItemDisplayStartTime;

    @Column
    private LocalDate ItemDisplayEndTime;

    @Builder
    public Product(Long itemId, String itemName, ItemType itemType, Long itemPrice,
                   LocalDate itemDisplayStartTime, LocalDate itemDisplayEndTime) {
        ItemId = itemId;
        ItemName = itemName;
        ItemType = itemType;
        ItemPrice = itemPrice;
        ItemDisplayStartTime = itemDisplayStartTime;
        ItemDisplayEndTime = itemDisplayEndTime;
    }

    public ProductPostResponseDto convertToResponseDto() {
        return ProductPostResponseDto.builder()
                .itemId(ItemId)
                .itemName(ItemName)
                .itemType(ItemType.getItemTypeString())
                .itemPrice(ItemPrice)
                .itemDisplayStartDate(ItemDisplayStartTime)
                .itemDisplayEndDate(ItemDisplayEndTime)
                .build();
    }
}
