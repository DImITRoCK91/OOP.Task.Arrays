// Автор: Прасков Дмитрий Сергеевич - ИВТ-25
// Задание №2 - работа с массивами (в задачнике №136_g)
package main.ZabGU;
import java.util.Random; // Данный класс используется для генерации псевдослучайных чисел
public class Main {

    // Функция, которая выполняет тестирование функции calcComp при помощи assert
    static void runTests() {

        // проверка на простые положительные числа
        assert Math.abs(calcComp(new double[]{1.0, 2.0, 3.0}) - 6.0) < 1e-6;

        // проверка на отрицательно число
        assert Math.abs(calcComp(new double[]{-1.5, 2.0}) - 3.0) < 1e-6;

        // проверка на большие числа
        assert Math.abs(calcComp(new double[]{500.0, -501.0}) - 250500.0) < 1e-3; // точность 10^-3

        // проверка на пустом массиве (произведение = 1)
        assert Math.abs(calcComp(new double[]{}) - 1.0) < 1e-6;

        // проверка с нулевым элементом (произведение = 0)
        assert Math.abs(calcComp(new double[]{5.0, 0.0, 7.0}) - 0.0) < 1e-6;

    }


    /// Функция для заполнения массива псевдослучайными числами
    // Формальные параметры: arr типа данных double, min - нижняя граница диапазона случайных чисел (double), max -  верхняя
    // Функции ничего не возвращает
    static void fillRandom(double[]arr, double min, double max){
        Random rnd = new Random(); // создаём объект для генерации случайных чисел
        // Random() - задаёт случайный сид для генерации чисел
        // Random(10) - задаёт определённый сид для генерации чисел

        // Цикл для заполнения массива псевдослучайными числами
        for (int i = 0; i < arr.length; i++){
            arr[i] = rnd.nextDouble(min, max); // Задаём диапазон
        }
    }

    /// Функция для вычисления выражения по примеру
    // Формальные параметры: arr - массив типа данных double
    // Функция возвращает переменную типа данных double - comp, результат вычисления
    static double calcComp(double[] arr){
        double comp = 1; // переменная для нахождения факториала чисел по модулю

        // Цикл, который вычисляет выражение
        for (int i = 0; i < arr.length; i++){
            comp *= Math.abs(arr[i]);
        }
        return comp;
    }

    /// Функция выводит массив, с указанным кол-вом элементов на одной строк
    // Формальные параметры: arr - массив типа данных double, inline - кол-во элементов массива на одной строке
    // Функция ничего не возвращает
    static void printArr(double[] arr, int inline){
        int k = 0;
        // Вывод массива, через использование улучшенного цикла for-each
        // (double a : arr)
        // double a - временная переменная, в которую будут записаны элементы массивы
        // : - разделяющий символ, означает 'из'
        // arr - объект, который мы перебираем
        for (double a : arr) {
            System.out.printf("%.2f ", a);
            k++;
            if (k % inline == 0) System.out.println(); // Вывод (inline) кол-ва элементов на одной строке
        }
        System.out.println();
    }

    public static void main(String[] args) {
        runTests();

        double arr[] = new double[20]; // Создаём объект массива типа данных
        fillRandom(arr, -10.0, 10.0);

        double comp = calcComp(arr);

        printArr(arr, 10);

        System.out.printf("%.2f \n", comp);
    }
}
