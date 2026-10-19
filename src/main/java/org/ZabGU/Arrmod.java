// Модуль для работы с массивом, заполнение массива, вычисление массива, вывод массива

package org.ZabGU;

import java.util.Random;

public class Arrmod {
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

    /// Функция для проверки параметров, введённых пользователем
    // Формальные параметры: size - кол-во элементов массива, min - нижняя граница диапазона,
    // max - верхняя граница диапазона, inline - кол-во элементов на одной строке при выводе
    // Функция ничего не возвращает
    // throws IllegalArgumentException - объявляет, что метод может выбросить это исключение,
    // вызывающий код (Main) обязан его обработать в блоке catch
    static void validateParams(int size, double min, double max, int inline) throws IllegalArgumentException {

        // throw - вручную выбрасывает исключение, если значение не подходит
        if (size <= 0) {
            throw new IllegalArgumentException("Кол-во элементов должно быть больше 0: " + size);
        }

        if (inline <= 0) {
            throw new IllegalArgumentException("Кол-во элементов в строке должно быть больше 0: " + inline);
        }

        // Проверка на NaN нужна, т.к. любое сравнение с NaN возвращает false
        // и такие значения проскочили бы проверку ниже
        if (Double.isNaN(min) || Double.isNaN(max)) {
            throw new IllegalArgumentException("Границы диапазона должны быть числами");
        }

        if (min >= max) {
            throw new IllegalArgumentException("Нижняя граница должна быть меньше верхней");
        }
    }

    /// Функция для заполнения массива псевдослучайными числами
    // Формальные параметры: arr типа данных double, min - нижняя граница диапазона случайных чисел (double), max - верхняя
    // Функции ничего не возвращает
    // throws IllegalArgumentException - массив null или пустой, либо некорректный диапазон
    static void fillRandom(double[] arr, double min, double max) throws IllegalArgumentException {

        // Обработка исключительный ситуаций
        // Массив не создан (ссылка равна null) - заполнять нечего
        if (arr == null){
            throw new IllegalArgumentException("Массив не может быть null");
        }

        // Массив нулевой длины - в него нельзя записать ни одного числа
        if (arr.length == 0){
            throw new IllegalArgumentException("Массив не может быть пустым");
        }

        // Границы равны или перепутаны местами: rnd.nextDouble(min, max) сам бросает
        // исключение при min >= max, поэтому проверяем заранее и даём понятное сообщение
        if (min >= max){
            throw new IllegalArgumentException("Нижняя граница диапазона должна быть меньше верхней");
        }


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
    // throws IllegalArgumentException - массив равен null
    // throws ArithmeticException - результат слишком велик для типа double (переполнение)
    static double calcComp(double[] arr) throws IllegalArgumentException, ArithmeticException {

        // Массив не создан - вычислять нечего
        if (arr == null){
            throw new IllegalArgumentException("Массив не может быть null");
        }

        double comp = 1; // переменная для нахождения факториала чисел по модулю

        // Цикл, который вычисляет выражение
        for (int i = 0; i < arr.length; i++){
            comp *= Math.abs(arr[i]);
        }

        // При переполнении double не бросает исключение сам, а превращается в Infinity,
        // поэтому выбрасываем ArithmeticException вручную
        if (Double.isInfinite(comp)){
            throw new ArithmeticException("Переполнение: произведение не помещается в double");
        }
        return comp;
    }

    /// Функция выводит массив, с указанным кол-вом элементов на одной строк
    // Формальные параметры: arr - массив типа данных double, inline - кол-во элементов массива на одной строке
    // Функция ничего не возвращает
    // throws IllegalArgumentException - массив равен null или inline не положительный
    static void printArr(double[] arr, int inline) throws IllegalArgumentException {

        // Массив не создан - выводить нечего
        if (arr == null){
            throw new IllegalArgumentException("Массив не может быть null");
        }

        // inline <= 0 привёл бы к делению на 0 в k % inline (ArithmeticException) или к отсутствию переносов строк
        if (inline <= 0) {
            throw new IllegalArgumentException("inline аргумент должен быть положительным");
        }

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

}