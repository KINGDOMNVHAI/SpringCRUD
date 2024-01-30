package com.codewithproject.springsecurity.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayUtil {



    public static List<String> stringToIntArray(String str) {
        List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
        return items;
    }

    public static void overturnValuesIntArray() {
        Random rand = new Random();
        List<String> givenList = Arrays.asList("one", "two", "three", "four");

        int numberOfElements = 2;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            String randomElement = givenList.get(randomIndex);
        }
    }
}
