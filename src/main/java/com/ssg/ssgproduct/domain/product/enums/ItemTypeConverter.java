package com.ssg.ssgproduct.domain.product.enums;

import com.ssg.ssgproduct.domain.user.enums.UserStat;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ItemTypeConverter implements AttributeConverter<ItemType, String> {

    @Override
    public String convertToDatabaseColumn(ItemType attribute) {
        return attribute.getItemTypeString();
    }

    @Override
    public ItemType convertToEntityAttribute(String dbData) {
        return ItemType.nameOf(dbData);
    }
}