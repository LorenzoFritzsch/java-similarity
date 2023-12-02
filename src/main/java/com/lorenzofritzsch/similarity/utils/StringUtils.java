package com.lorenzofritzsch.similarity.utils;

public class StringUtils {

    private StringUtils() { }

    public static String tail(String x) {
        return x.substring(1);
    }

    public static String head(String x) {
        return String.valueOf(x.charAt(0));
    }
}
