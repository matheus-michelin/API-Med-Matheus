package med.matheus.API.Med.Matheus.converter;

import jakarta.persistence.AttributeConverter;

public class SmallIntBooleanConveter implements AttributeConverter<Boolean, Short>{


    @Override
    public Short convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? (short) 1 : (short) 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Short dbData) {
        return dbData != null && dbData == 1;
    }
}
