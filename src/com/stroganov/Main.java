package com.stroganov;


/**
 * Задание. Ввести n чисел с консоли.
 * <p>
 * 1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
 * 2.     Вывести числа в порядке возрастания (убывания) значений их длины.
 * 3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
 * 4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
 * 5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
 * 6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
 * 7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 * 8.     Среди чисел найти число-палиндром. Если таких чисел больше одного, найти второе.
 *
 * @author Sergey Stroganov
 * @since 1.0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Main method.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> integerArrayList = Main.getUserNumbers();
        if (integerArrayList.isEmpty()) {
            System.out.println("Нет данных для обработки, программа будет завершена");
            System.exit(0);
        }

        // 1
        System.out.println("Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
        Integer[] arrayMinMax = NumberUtils.getMinMaxNumberLengths(integerArrayList);
        System.out.println("Число с минимальным количеством символов: " + arrayMinMax[0] + " его длинна: " + arrayMinMax[0].toString().length());
        System.out.println("Число с максимальным количеством символов: " + arrayMinMax[1] + " его длинна: " + arrayMinMax[1].toString().length());

        //2
        System.out.println("Вывести числа в порядке возрастания (убывания) значений их длины.");
        NumberUtils.sortByNumberLengths(integerArrayList);
        integerArrayList.forEach(System.out::println);

        // 3
        System.out.println("Вывести на консоль те числа, длина которых меньше средней длины по всем числам, а также длину.");
        ArrayList<Integer> arraySpecialLengths = NumberUtils.getNumbersLengthsLessMedium(integerArrayList);
        if (!arraySpecialLengths.isEmpty()) {
            arraySpecialLengths.forEach(x -> System.out.println("Число: " + x + " длинна символов: " + x.toString().length()));
        } else System.out.println("Нет чисел подходящих под условие");

        // 4

        System.out.println("Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.");
        int s = NumberUtils.getMinDifferentNumbers(integerArrayList);
        System.out.println("Первое число, в котором количество различных цифр минимально: " + s);

        // 5

        System.out.println("Найти количество чисел, содержащих только четные цифры, а среди них — количество чисел с равным числом четных и нечетных цифр.");
        int[] buffer = NumberUtils.getCountEvenNumbers(integerArrayList);
        System.out.println("Количество чисел только с четными цифрами: " + buffer[0]);
        System.out.println("Количество чисел  с четными и нечетными с равным числом: " + buffer[1]);

        // 6

        System.out.println("Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.");
        int increaseDigitNumber = NumberUtils.getNumberIncreaseDigit(integerArrayList);
        if (increaseDigitNumber != 0) {
            System.out.println(increaseDigitNumber);
        } else System.out.println("Число по заданному условию не найдено");

        // 7
        System.out.println("Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.");
        int numberMaxDifferentDigit = NumberUtils.getNumberMaxDifferentDigit(integerArrayList);
        System.out.println("Число с максимальным количеством разных знаков " + numberMaxDifferentDigit);

        // 8
        System.out.println("Среди чисел найти число-палиндром. Если таких чисел больше одного, найти второе.");
        ArrayList<Integer> palindromeNumberArray = NumberUtils.getPalindromeNumbers(integerArrayList);
        if (!palindromeNumberArray.isEmpty()) {
            palindromeNumberArray.forEach(x -> System.out.println("Найдено число палиндром: " + x));
        } else {
            System.out.println("Чисел палиндромов не найдено");
        }


        System.out.println("Автор: Сергей Строгановй, дата получения задания 16.06.2021, дата сдачи задания 18.06.2021");
    }

    /**
     * The method returns a list of numbers entered by the user from the keyboard.
     * The input stops when you enter the "y" character or the "q" character.
     * @return array of Integer
     */

    public static ArrayList<Integer> getUserNumbers() {
        ArrayList<Integer> arrayInteger = new ArrayList<>();
        System.out.println("Введите числа. Для завершения введите 'q'");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {

                String tempString = reader.readLine();
                if (tempString.equals("q") || tempString.equals("й")) {
                    break;
                }
                arrayInteger.add(Integer.parseInt(tempString));
            }
        } catch (NumberFormatException f) {
            System.err.println("Неправильный формат введенного последнего числа: " + f + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка чтения с консоли: " + e + "\n");
        }
        return arrayInteger;
    }
}
