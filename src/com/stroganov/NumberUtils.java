package com.stroganov;

import java.util.ArrayList;

public class NumberUtils {


    public static Integer[] getMinMaxNumberLengths(ArrayList<Integer> integerArrayList) {

        if (integerArrayList.size() < 2) {
            throw new IllegalArgumentException();
        }

        int maxLengths = 0;
        int minLengths = integerArrayList.get(0).toString().length();
        int numberMaxLengths = 0;
        int numberMinLengths = 0;
        for (Integer number : integerArrayList) {
            int numberLengths = number.toString().length();
            if (numberLengths > maxLengths) {
                maxLengths = numberLengths;
                numberMaxLengths = number;
            } else if (numberLengths < minLengths) {
                minLengths = numberLengths;
                numberMinLengths = number;
            }
        }

        return new Integer[]{numberMinLengths, numberMaxLengths};

    }


}
