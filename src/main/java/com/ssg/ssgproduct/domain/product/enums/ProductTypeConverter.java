package com.ssg.ssgproduct.domain.product.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProductTypeConverter implements AttributeConverter<ProductType, String> {

    @Override
    public String convertToDatabaseColumn(ProductType attribute) {
        return attribute.getItemTypeString();
    }

    @Override
    public ProductType convertToEntityAttribute(String dbData) {
        return ProductType.nameOf(dbData);
    }
}