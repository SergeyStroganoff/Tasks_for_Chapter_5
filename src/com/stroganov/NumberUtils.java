package com.stroganov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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


    public static int numberLength(int anyNumber) { // метод определения длинны числа в символах без учета знака отрицания
        int result = 0;

        if (anyNumber < 0) {
            anyNumber = -anyNumber;
        }

        if (anyNumber == 0) {
            return result + 1;
        }

        while (anyNumber > 0) {
            anyNumber /= 10;
            result++;
        }

        return result;
    }

    private static Comparator<Integer> compareNumberLengths() {
        return (o1, o2) -> o1.toString().length() - o2.toString().length();
    }


    public static void sortByNumberLengths(ArrayList<Integer> integerArrayList) {
        Collections.sort(integerArrayList, compareNumberLengths());
    }
}
