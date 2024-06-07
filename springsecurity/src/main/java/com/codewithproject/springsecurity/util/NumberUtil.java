package com.codewithproject.springsecurity.util;

import java.text.DecimalFormat;

public class NumberUtil {

    public static final double PI = 3.14159265359;
    static final double GOLDEN_RATIO = 1.6180;
    static final double GRAVITATIONAL_ACCELERATION = 9.8;
    static final double EULERS_NUMBER = 2.7182818284590452353602874713527;

    /*
    * Input: 1
    * Output: 00001
    * */
    public static String giveZeroBeforeNumber(String zeroStr, int number) {
        DecimalFormat df = new DecimalFormat(zeroStr);
        return df.format(number);
    }
}
