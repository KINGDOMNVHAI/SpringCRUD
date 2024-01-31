package com.codewithproject.springsecurity.util;

import java.util.Arrays;
import java.util.List;

public class ArrayUtil {

    public static List<String> ARRAY_ALPHABET = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"
            , "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    public static List<String> stringToIntArray(String str) {
        return Arrays.asList(str.split("\\s*,\\s*"));
    }
}

// Xao tron danh sách Collections.shuffle(listStrAnswer);