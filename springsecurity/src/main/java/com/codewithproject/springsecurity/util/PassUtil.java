package com.codewithproject.springsecurity.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PassUtil {

    public static String encryptMD5(String input) {
        try {
            // Create instance of MD5 message digest
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Convert the input string to bytes
            byte[] inputBytes = md.digest(input.getBytes());

            BigInteger bigInt = new BigInteger(1, inputBytes);

            return bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
