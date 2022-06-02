package com.ssg.ssgproduct.domain.customer.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CustomerStatConverter implements AttributeConverter<CustomerStat, String> {

    @Override
    public String convertToDatabaseColumn(CustomerStat attribute) {
        return attribute.getUserStatString();
    }

    @Override
    public CustomerStat convertToEntityAttribute(String dbData) {
        return CustomerStat.nameOf(dbData);
    }
}