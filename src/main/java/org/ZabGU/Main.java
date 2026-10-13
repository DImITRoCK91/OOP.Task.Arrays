// Автор: Прасков Дмитрий Сергеевич - ИВТ-25
// Задание №2 - работа с массивами (в задачнике №136_g)
package org.ZabGU;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Arrmod.runTests();

        int a, inline; double min, max;

        if (args.length > 0 && (args[0].equals("help") || args[0].equals("--help"))){
            printhelp();
            return;
        }

        if (args.length == 4){
            a = Integer.parseInt(args[0]);
            min = Double.parseDouble(args[1]);
            max = Double.parseDouble(args[2]);
            inline = Integer.parseInt(args[3]);
        }
        else {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите кол-во элементов в массиве");
            a = in.nextInt();

            System.out.println("Введите диапазон значений (нижняя и верхняя границы через пробел)");
            min = in.nextDouble();
            max = in.nextDouble();

            System.out.println("Введите сколько нужно вывести элементов на одной строке");
            inline = in.nextInt();
        }

        double arr[] = new double[a]; // Создаём объект массива типа данных
        Arrmod.fillRandom(arr, min, max);

        double comp = Arrmod.calcComp(arr);

        Arrmod.printArr(arr, inline);

        System.out.printf("%.2f \n", comp);
    }

    private static void printhelp(){
        System.out.println("  Справка:");
        System.out.println("  java Main                            - ввод данных через консоль");
        System.out.println("  java Main <a> <min> <max> <inline>   - передача значений через аргументы");
        System.out.println("  java Main help                       - вывод этой справки");
        System.out.println("  java Main --help                     - вывод этой справки");
    }
}