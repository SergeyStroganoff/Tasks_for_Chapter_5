package com.stroganov;


/*
Задание. Ввести n чисел с консоли.

1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
2.     Вывести числа в порядке возрастания (убывания) значений их длины.
3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
        int s = NumberUtils.findMinDifferentNumbers(integerArrayList);
        System.out.println("Первое число, в котором количество различных цифр минимально: " + s);

        // 5

        System.out.println("Найти количество чисел, содержащих только четные цифры, а среди них — количество чисел с равным числом четных и нечетных цифр.");
        int [] buffer = NumberUtils.getCountEvenNumbers(integerArrayList);
        System.out.println("Количество чисел только с четными цифрами: " + buffer[0]);
        System.out.println("Количество чисел  с четными и нечетными с равным числом: " + buffer[1]);

        // 6

        System.out.println("Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.");

    }


    public static ArrayList<Integer> getUserNumbers() {
        ArrayList<Integer> arrayInteger = new ArrayList<>();
        System.out.println("Введите числа. Для завершения введите 'q'");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {

                String tempString = reader.readLine();
                if (tempString.equals("q")) {
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
