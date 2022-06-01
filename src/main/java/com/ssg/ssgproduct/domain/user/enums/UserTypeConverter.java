package com.ssg.ssgproduct.domain.user.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserTypeConverter implements AttributeConverter<UserType, String> {

    @Override
    public String convertToDatabaseColumn(UserType attribute) {
        return attribute.getUserTypeString();
    }

    @Override
    public UserType convertToEntityAttribute(String dbData) {
        return UserType.nameOf(dbData);
    }
}