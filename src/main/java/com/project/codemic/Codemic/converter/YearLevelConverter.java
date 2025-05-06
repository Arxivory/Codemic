package com.project.codemic.Codemic.converter;

import com.project.codemic.Codemic.model.enums.YearLevel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class YearLevelConverter implements AttributeConverter<YearLevel, Integer> {

    @Override
    public Integer convertToDatabaseColumn(YearLevel attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public YearLevel convertToEntityAttribute(Integer databaseData) {
        return databaseData != null ? YearLevel.fromValue(databaseData) : null;
    }
}
