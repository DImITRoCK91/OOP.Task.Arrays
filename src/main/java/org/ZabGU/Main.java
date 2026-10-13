// Автор: Прасков Дмитрий Сергеевич - ИВТ-25
// Задание №2 - работа с массивами (в задачнике №136_g)
package org.ZabGU;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Arrmod.runTests();

        Scanner in = new Scanner(System.in);

        System.out.println("Введите кол-во элементов в массиве");
        int a = in.nextInt();

        System.out.println("Введите диапазон значений (нижняя и верхняя границы через пробел)");
        double min = in.nextDouble();
        double max = in.nextDouble();

        System.out.println("Введите сколько нужно вывести элементов на одной строке");
        int inline = in.nextInt();

        double arr[] = new double[a]; // Создаём объект массива типа данных
        Arrmod.fillRandom(arr, min, max);

        double comp = Arrmod.calcComp(arr);

        Arrmod.printArr(arr, inline);

        System.out.printf("%.2f \n", comp);
    }
}