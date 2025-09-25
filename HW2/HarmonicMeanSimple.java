package Home.HW2;

import java.util.Scanner;

public class HarmonicMeanSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть кількість елементів: ");
        int n = sc.nextInt();

        double[] arr = new double[n];

        System.out.println("Введіть " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + 1 / arr[i];
        }

        double harmonicMean = n / sum;

        System.out.println("Середнє гармонічне = " + harmonicMean);
    }
}
