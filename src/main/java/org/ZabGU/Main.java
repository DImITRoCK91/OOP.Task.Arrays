// Автор: Прасков Дмитрий Сергеевич - ИВТ-25
// Задание №2 - работа с массивами (в задачнике №136_g)
package org.ZabGU;
import java.util.Random; // Данный класс используется для генерации псевдослучайных чисел
public class Main {



    public static void main(String[] args) {
        Arrmod.runTests();

        double arr[] = new double[20]; // Создаём объект массива типа данных
        Arrmod.fillRandom(arr, -10.0, 10.0);

        double comp = Arrmod.calcComp(arr);

        Arrmod.printArr(arr, 10);

        System.out.printf("%.2f \n", comp);
    }
}
