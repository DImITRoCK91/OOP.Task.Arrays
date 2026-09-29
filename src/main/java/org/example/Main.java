package org.example;
import javax.sound.midi.Soundbank;
import java.util.Random;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        int k = 0;
        Random rnd = new Random();
        System.out.println("");
        double arr[] = new double[100];

        for (int i = 0; i < arr.length; i++){
            arr[i] = rnd.nextDouble(-100.0, 100.0);
        }

        for (double a : arr) {
            System.out.printf("%.2f ", a);
            k++;
            if (k % 10 == 0) System.out.println();
        }
    }
}
