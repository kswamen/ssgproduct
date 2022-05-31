package com.ssg.ssgproduct.domain.user;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

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