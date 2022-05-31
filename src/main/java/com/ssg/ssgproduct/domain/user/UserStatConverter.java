package com.ssg.ssgproduct.domain.user;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

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