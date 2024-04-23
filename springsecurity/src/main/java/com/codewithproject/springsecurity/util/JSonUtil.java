package com.codewithproject.springsecurity.util;

import com.codewithproject.springsecurity.dto.entitydto.VideoDto;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringWriter;

public class JSonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String toJSonString(Object o) {
        try {
            StringWriter writer = new StringWriter();
            JsonFactory factory = MAPPER.getFactory();
            JsonGenerator gen = factory.createGenerator(writer);
            MAPPER.writeValue(gen, o);
            gen.close();
            String json = writer.toString();
            writer.close();
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String obj2JSon(Object o) {
        try {
            StringWriter writer = new StringWriter();
            JsonFactory factory = MAPPER.getFactory();
            JsonGenerator gen = factory.createGenerator(writer);
            MAPPER.writeValue(gen, o);
            gen.close();
            String json = writer.toString();
            writer.close();
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static <T> T str2bean(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T str2beanIgnoreUnknowProperties(String json, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("rawtypes")
    public static Object str2list(String json, Class<VideoDto> valueTypeRef) {
        try {
            return MAPPER.readValue(json, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
