package com.stroganov;

import java.util.*;

/**
 * A class for processing a list of numbers using different methods.
 * * @since   1.0
 * * @author Sergey Stroganov
 */

public class NumberUtils {
    /**
     * The method returns a number with the minimum and a number with the maximum number of digits.
     *
     * @param integerArrayList array of Integer
     * @return An array of two numbers Integer
     */


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

    /**
     * The method returns the length of the number in characters
     * without taking into account the negative sign
     *
     * @param anyNumber int
     * @return int numberLength
     */


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

    /**
     * The method sorts the list based on the number of characters in the number.
     *
     * @param integerArrayList - array of Integer
     */
    public static void sortByNumberLengths(ArrayList<Integer> integerArrayList) {
        Collections.sort(integerArrayList, compareNumberLengths());
    }

    /**
     * The method returns numbers whose length is less than the average length across all the numbers
     *
     * @param integerArrayList - array of Integer
     * @return array of Integer
     */


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

    /**
     * The method returns a number from the list,
     * in which the number of different digits is minimal.
     *
     * @param integerArrayList - array of Integer
     * @return int
     */

    public static int getMinDifferentNumbers(ArrayList<Integer> integerArrayList) {

        ArrayList<Integer> arrayUniqueSymbols = new ArrayList<>(); // временный список
        Set<String> set = new HashSet<>();

        for (int index : integerArrayList) {

            if (index < 10 && index > -10) {
                return index;
            } // если нашли однозначное число, возвращаем именно его

            String s = String.valueOf(index);
            String[] arr = s.split("");


            for (int i = 0; i < s.length(); i++) { // ищем количество уникальных символов
                if (!arr[i].equals("-")) {
                    set.add(arr[i]);
                }
            }
            arrayUniqueSymbols.add(set.size());
            set.clear();
        }
        ArrayList<Integer> tempArray = (ArrayList<Integer>) arrayUniqueSymbols.clone();
        Collections.sort(tempArray);
        int index = arrayUniqueSymbols.indexOf(tempArray.get(0));
        return integerArrayList.get(index);

    }

    /**
     * The method returns a list of single digits
     * that make up a number in the correct order
     *
     * @param number - int
     * @return array of Integer
     */


    public static ArrayList<Integer> getDigitsNumber(int number) {
        ArrayList<Integer> arrayListDigit = new ArrayList<>();
        while (number != 0) {
            arrayListDigit.add(number % 10);
            number /= 10;
        }
        Collections.reverse(arrayListDigit);
        return arrayListDigit;

    }

    /**
     * The method returns the number of numbers
     * containing only even digits,
     * and the number of numbers with an equal number of even and odd digits.
     *
     * @param integerArrayList array of Integer
     * @return int[] result - buffer of two numbers.
     * The fist is number of numbers containing only even digits,
     * the second number of numbers with an equal number of even and odd digits.
     */


    public static int[] getCountEvenNumbers(ArrayList<Integer> integerArrayList) {

        int[] result = new int[2];
        int countNumbersOnlyEven = 0;
        int countNumbersFiftyFifty = 0;

        for (Integer number : integerArrayList) {
            ArrayList<Integer> arrayListDigit = getDigitsNumber(number);
            long evenDigitCount = arrayListDigit.stream()
                    .filter(x -> x % 2 == 0)
                    .count();

            int numberDigits = numberLength(number);
            int oddDigitCount = numberDigits - (int) evenDigitCount;

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

    /**
     * The method returns a number whose digits are in strict ascending order.
     *
     * @param integerArrayList array of Integer.
     * @return int
     */
    public static int getNumberIncreaseDigit(ArrayList<Integer> integerArrayList) {

        for (Integer number : integerArrayList) {
            ArrayList<Integer> arrayListDigit = getDigitsNumber(number);
            if (arrayListDigit.size() >= 2 && arrayListDigit.size() <= 10) {
                int count = 0;
                for (int n = 1; n < arrayListDigit.size(); n++) {
                    if (arrayListDigit.get(n - 1) < arrayListDigit.get(n)) {
                        count++;
                    }// ВОПРОС!?
                }
                if (count == arrayListDigit.size() - 1) return number;
            }
        }
        return 0;
    }

    /**
     * The method returns a number consisting only of different digits.
     *
     * @param integerArrayList array of Integer
     * @return Integer first number with different digits
     */

    public static Integer getNumberDifferentDigit(ArrayList<Integer> integerArrayList) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        ArrayList<Integer> tempArrayUniqueSymbols = new ArrayList<>();
        for (Integer number : integerArrayList) {
            ArrayList<Integer> arrayListDigit = getDigitsNumber(number);
            if (arrayListDigit.size() == 1) return number;
            integerHashSet.addAll(arrayListDigit);
            if (integerHashSet.size() == arrayListDigit.size()) return number;
            tempArrayUniqueSymbols.add(integerHashSet.size());
            integerHashSet.clear();
        }
        ArrayList<Integer> tempArray = (ArrayList<Integer>) tempArrayUniqueSymbols.clone();
        Collections.sort(tempArray);
        int index = tempArrayUniqueSymbols.indexOf(tempArray.get(tempArray.size() - 1));
        return integerArrayList.get(index);
    }

    /**
     * The method returns true if the number is a palindrome.
     *
     * @param number int
     * @return boolean
     */

    public static boolean isPalindrome(int number) {
        if (number == reverseInt(number)) {
            return true;
        } else {
            return false;
        }
    }

    private static int reverseInt(int number) {
        int reverseInt = 0;

        while (number != 0) {
            reverseInt = reverseInt * 10 + number % 10;
            number /= 10;
        }
        return reverseInt;
    }

    /**
     * Method returns array of the   palindrome numbers if preset in array.
     *
     * @param integerArrayList array of Integer
     * @return array of Integer
     */

    public static ArrayList<Integer> getPalindromeNumbers(ArrayList<Integer> integerArrayList) {
        ArrayList<Integer> palindromeNumberArray = new ArrayList<>();

        for (Integer currentNumber : integerArrayList) {

            if (isPalindrome(currentNumber)) {
                palindromeNumberArray.add(currentNumber);
            }
        }
        return palindromeNumberArray;
    }
}
