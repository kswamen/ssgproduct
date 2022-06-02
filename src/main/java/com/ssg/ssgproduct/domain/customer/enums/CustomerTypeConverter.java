package com.ssg.ssgproduct.domain.customer.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CustomerTypeConverter implements AttributeConverter<CustomerType, String> {

    @Override
    public String convertToDatabaseColumn(CustomerType attribute) {
        return attribute.getUserTypeString();
    }

    @Override
    public CustomerType convertToEntityAttribute(String dbData) {
        return CustomerType.nameOf(dbData);
    }
}