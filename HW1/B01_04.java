package Home.HW1;

import java.util.Scanner;

public class B01_04 {

    public static void main(String[] args) {
        System.out.println("Введи три цілих числа: ");

        Scanner in = new Scanner(System.in);
        System.out.print("a = ");
        double a = in.nextDouble();
        System.out.print("b = ");
        double b = in.nextDouble();
        System.out.print("c = ");
        double c = in.nextDouble();

        double g = Math.pow(a*b*c, 1.0/3);

        System.out.printf("Середнє геометричне: %.4f", g);

        in.close();
    }

}