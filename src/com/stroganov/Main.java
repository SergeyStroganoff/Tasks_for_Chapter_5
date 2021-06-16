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


        ArrayList<Integer> array = new ArrayList<>();
        System.out.println("Введите числа. Для завершения введите 'q'");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {

                String tempString = reader.readLine();
                if (tempString.equals("q")) {
                    break;
                }
                array.add(Integer.parseInt(tempString));
            }
        } catch (NumberFormatException f) {
            System.err.println("Неправильный формат введенного последнего числа: " + f + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка чтения с консоли: " + e + "\n");
        }



    }
}
