package com.stroganov;

import java.util.*;

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
            }
            if (numberLengths <= minLengths) {
                minLengths = numberLengths;
                numberMinLengths = number;
            }
        }

        return new Integer[]{numberMinLengths, numberMaxLengths};

    }


    public static int numberLength(int anyNumber) { // метод определения длинны числа в символах без учета знака отрицания
        if (anyNumber < 0) {
            anyNumber = -anyNumber;
        }
        Integer tempInteger = anyNumber;
        return tempInteger.toString().length();

    }

    private static Comparator<Integer> compareNumberLengths() {
        return (o1, o2) -> o1.toString().length() - o2.toString().length();
    }


    public static void sortByNumberLengths(ArrayList<Integer> integerArrayList) {
        Collections.sort(integerArrayList, compareNumberLengths());
    }


    public static ArrayList<Integer> getNumbersLengthsLessMedium(ArrayList<Integer> integerArrayList) {

        ArrayList<Integer> resultArrayList = new ArrayList<>();

        int allLength = 0;
        for (int number : integerArrayList) {
            allLength += numberLength(number);
        }
        int mediumLength = allLength / integerArrayList.size();
        for (int arrayNumber : integerArrayList) {
            if (numberLength(arrayNumber) < mediumLength) {
                resultArrayList.add(arrayNumber);
            }
        }
        return resultArrayList;
    }

    public static int findMinDifferentNumbers(ArrayList<Integer> integerArrayList) {
        int result = 0;

        ArrayList<Integer> arrayUniqueSymbols = new ArrayList<>(); // временный список

        Set<String> set = new HashSet<>();

        for (int index : integerArrayList) {

            if (index < 10 && index > -10) {
                return index;
            } // если нашли однозначное число, возвращаем именно его

            String s = String.valueOf(index);
            String[] arr = s.split("");

            int count;
            for (int i = 0; i < s.length(); i++) { // ищем количество уникальных символов
                if (!arr[i].equals("-")) {
                    set.add(arr[i]);
                }
            }
            count = set.size();
            set.clear();
            arrayUniqueSymbols.add(count);
        }
        ArrayList<Integer> tempArray = (ArrayList<Integer>) arrayUniqueSymbols.clone();
        Collections.sort(tempArray);
        int index = arrayUniqueSymbols.indexOf(tempArray.get(0));
        return integerArrayList.get(index);

    }


    public static int[] getCountEvenNumbers(ArrayList<Integer> integerArrayList) {

        int[] result = new int[2];
        int countNumbersOnlyEven = 0;
        int countNumbersFiftyFifty = 0;

        for (Integer number : integerArrayList) {

            int tempNumber = number;
            ArrayList<Integer> arrayListDigit = new ArrayList<>();
            while (tempNumber != 0) {
                arrayListDigit.add(tempNumber % 10);
                tempNumber /= 10;
            }
           long evenDigitCount = arrayListDigit.stream()
                    .filter(x -> x % 2 == 0)
                    .count();

            int numberDigits = numberLength(number);
            int oddDigitCount = numberDigits - (int) evenDigitCount;
            System.out.println(oddDigitCount + "нечетных тут");

            if (numberDigits == (int) evenDigitCount) {
                countNumbersOnlyEven++;
            }

            if (evenDigitCount == oddDigitCount) {
                countNumbersFiftyFifty++;
            }
        }
        result[0] = countNumbersOnlyEven;
        result[1] = countNumbersFiftyFifty;
        return result;
    }
}
