package Home.HW2;
import java.util.Scanner;

public class CyclicShift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть число (0..255): ");
        int n = sc.nextInt();

        int x = n & 0xFF;


        int msb = (x >> 7) & 1;


        int shifted = ((x << 1) & 0xFF) | msb;

        System.out.println("res = " + shifted);
    }
}

