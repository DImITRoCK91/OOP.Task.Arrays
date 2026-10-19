// Автор: Прасков Дмитрий Сергеевич - ИВТ-25
// Задание №2 - работа с массивами (в задачнике №136_g)
package org.ZabGU;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Arrmod.runTests();

        ///  try - ограничивает блок кода, в котором может возникнуть ошибка
        try {
            int a, inline;
            double min, max;

            if (args.length > 0 && (args[0].equals("help") || args[0].equals("--help"))) {
                printhelp();
                return;
            }

            if (args.length == 4) {
                a = Integer.parseInt(args[0]); // может быть брошено исключение
                min = Double.parseDouble(args[1]);
                max = Double.parseDouble(args[2]);
                inline = Integer.parseInt(args[3]);
            } else if (args.length == 0) {
                Scanner in = new Scanner(System.in);

                System.out.println("Введите кол-во элементов в массиве");
                a = in.nextInt();

                System.out.println("Введите диапазон значений (нижняя и верхняя границы через пробел)");
                min = in.nextDouble();
                max = in.nextDouble();

                System.out.println("Введите сколько нужно вывести элементов на одной строке");
                inline = in.nextInt();
            } else {
                // Неверное кол-во аргументов - сообщаем пользователю и показываем справку
                System.out.println("Неверное кол-во аргументов: ожидалось 4, получено " + args.length);
                printhelp();
                return;
            }

            // Проверка введённых значений теперь выполняется в модуле Arrmod
            // (может бросить IllegalArgumentException)
            Arrmod.validateParams(a, min, max, inline);

            double arr[] = new double[a]; // Создаём объект массива типа данных
            Arrmod.fillRandom(arr, min, max);

            double comp = Arrmod.calcComp(arr);

            Arrmod.printArr(arr, inline);

            System.out.printf("%.2f \n", comp);
        }
        // catch - выполняется только если в блоке try произошла ошибка указанного типа
        // NumberFormatException - наследник IllegalArgumentException, поэтому он стоит выше
        catch (NumberFormatException e){
            System.out.println("Аргументы должны быть числами");
        }
        catch (InputMismatchException e){
            System.out.println("Введено не число");
        }
        catch (NoSuchElementException e){
            System.out.println("Ввод данных прерван");
        }
        // Ошибки, брошенные в Arrmod, выводим вместе с сообщением из исключения
        catch (IllegalArgumentException e){
            System.out.println("Ошибка в данных: " + e.getMessage());
        }
        catch (ArithmeticException e){
            System.out.println("Арифметическая ошибка: " + e.getMessage());
        }
        catch (OutOfMemoryError e) {
            System.out.println("Слишком большой размер массива");
        }
    }
    private static void printhelp(){
        System.out.println("  Справка:");
        System.out.println("  java Main                            - ввод данных через консоль");
        System.out.println("  java Main <a> <min> <max> <inline>   - передача значений через аргументы");
        System.out.println("  java Main help                       - вывод этой справки");
        System.out.println("  java Main --help                     - вывод этой справки");
    }
}