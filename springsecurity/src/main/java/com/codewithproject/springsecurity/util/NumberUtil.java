package com.codewithproject.springsecurity.util;

import java.text.DecimalFormat;

public class NumberUtil {

    public static String giveZeroBeforeNumber(String zeroStr, int number) {
        DecimalFormat df = new DecimalFormat(zeroStr);
        return df.format(number);
    }
}
