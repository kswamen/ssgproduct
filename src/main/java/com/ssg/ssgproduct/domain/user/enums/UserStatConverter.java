package com.ssg.ssgproduct.domain.user.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserStatConverter implements AttributeConverter<UserStat, String> {

    @Override
    public String convertToDatabaseColumn(UserStat attribute) {
        return attribute.getUserStatString();
    }

    @Override
    public UserStat convertToEntityAttribute(String dbData) {
        return UserStat.nameOf(dbData);
    }
}