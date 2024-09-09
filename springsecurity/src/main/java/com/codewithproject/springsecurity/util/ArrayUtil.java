package com.codewithproject.springsecurity.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ArrayUtil {

    public static List<String> ARRAY_ALPHABET = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"
            , "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    public static List<String> stringToIntArray(String str) {
        return Arrays.asList(str.split("\\s*,\\s*"));
    }

    public static String removeStringArray(String strArray) {
        char charArrBegin = '[';
        char charArrEnd = ']';
        String first = strArray.replace(String.valueOf(charArrBegin), "");
        return first.replace(String.valueOf(charArrEnd), "");
    }

    public static List<Object> convertMapValuesToList(Map<String, Object> map) {
        return new ArrayList<>(map.values());
    }
}

// Xao tron danh sách Collections.shuffle(listStrAnswer);