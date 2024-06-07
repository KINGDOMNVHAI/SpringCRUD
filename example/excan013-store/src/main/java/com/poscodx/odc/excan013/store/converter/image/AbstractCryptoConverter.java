package com.poscodx.odc.excan013.store.converter.image;

import com.poscdx.odc.excan013.domain.utils.Constants;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
abstract class AbstractCryptoConverter<T> implements AttributeConverter<T, String> {

    @Override
    public String convertToDatabaseColumn(T attribute) {
        if (attribute != null) {
            return ((String) attribute)
                    .replaceAll(Constants.UPLOAD_URL + Constants.UPLOAD_BUCKET + "/", "");
        }
        return null;
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        return stringToEntityAttribute(Constants.formatUrl(dbData));
    }

    abstract T stringToEntityAttribute(String dbData);
}