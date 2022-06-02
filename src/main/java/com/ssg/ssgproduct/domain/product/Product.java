package com.ssg.ssgproduct.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssg.ssgproduct.domain.product.dtos.ProductPostResponseDto;
import com.ssg.ssgproduct.domain.product.enums.ProductType;
import com.ssg.ssgproduct.domain.product.enums.ProductTypeConverter;
import com.ssg.ssgproduct.domain.promotionproduct.PromotionProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductId;

    @Column
    private String ProductName;

    @Convert(converter = ProductTypeConverter.class)
    private ProductType ProductType;

    @Column
    private Long ProductPrice;

    @Column
    private LocalDate ProductDisplayStartTime;

    @Column
    private LocalDate ProductDisplayEndTime;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<PromotionProduct> promotionProducts;

    @Builder
    public Product(Long productId, String productName, ProductType productType, Long productPrice,
                   LocalDate productDisplayStartTime, LocalDate productDisplayEndTime) {
        this.ProductId = productId;
        this.ProductName = productName;
        this.ProductType = productType;
        this.ProductPrice = productPrice;
        this.ProductDisplayStartTime = productDisplayStartTime;
        this.ProductDisplayEndTime = productDisplayEndTime;
    }

    public ProductPostResponseDto convertToResponseDto() {
        return ProductPostResponseDto.builder()
                .productId(ProductId)
                .productName(ProductName)
                .productType(ProductType.getItemTypeString())
                .productPrice(ProductPrice)
                .productDisplayStartDate(ProductDisplayStartTime)
                .productDisplayEndDate(ProductDisplayEndTime)
                .build();
    }
}
