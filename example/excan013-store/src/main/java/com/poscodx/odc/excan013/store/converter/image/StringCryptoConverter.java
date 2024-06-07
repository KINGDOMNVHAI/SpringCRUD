package com.poscodx.odc.excan013.store.converter.image;

import javax.persistence.Converter;

@Converter
public class StringCryptoConverter extends AbstractCryptoConverter<String> {

    @Override
    String stringToEntityAttribute(String dbData) {
        return dbData;
    }
}