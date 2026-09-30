// Автор: Прасков Дмитрий Сергеевич - ИВТ-25
// Задание №2 - работа с массивами (в задачнике №136_g)
package org.example;
import java.util.Random; // Данный класс используется для генерации псевдослучайных чисел
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        int k = 0;
        double absfact = 1; // переменная для нахождения факториала чисел по модулю

        Random rnd = new Random(); // создаём объект для генерации случайных чисел
        // Random() - задаёт случайный сид для генерации чисел
        // Random(10) - задаёт определённый сид для генерации чисел

        System.out.println("");
        double arr[] = new double[20]; // Создаём объект массива типа данных

        for (int i = 0; i < arr.length; i++){
            arr[i] = rnd.nextDouble(-10.0, 10.0); // Задаём диапозон
        }

        // Цикл, который считает факториал чисел по модулю
        for (int i = 0; i < arr.length; i++){
            absfact *= Math.abs(arr[i]);

        }

        // Вывод массива, через использование коллекций
        // (double a : arr)
        // double a - временная переменная, в которую будут записаны элементы массивы
        // : - разделяющий символ, означает 'из'
        // arr - объект, который мы перебираем
        for (double a : arr) {
            System.out.printf("%.2f ", a);
            k++;
            if (k % 10 == 0) System.out.println(); // Вывод 10 элементов на одной строке
        }
        System.out.println();
        System.out.printf("%.2f \n", absfact);
    }
}
