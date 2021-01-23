package com.esq.e_grocery.utils;

/**
 * Utility class containing methods for Int to String conversion
 */

public class StringUtils {

    public static String getWeightString(int weight){
        return ("Net wt." + weight + "kg");
    }

    public static String getFoodPriceString(int price) {
        return ("₦" + price);
    }
}
