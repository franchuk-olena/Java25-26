package Home.HW7;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class B07_01 {


    public static void main(String[] args) {
        String fileF = "src/Home/HW7/input01.int32";
        String fileG = "src//Home/HW7/output01.int32";

        // Початковий масив дійсних чисел
        double[] numbers = {1.5, -2.3, 3.14, 0.0, 7.8, 4.5, -1.2};
        double a = 2.0;

        // файл F
        writeToFile(fileF, numbers);

        // Зчитування масиву з файлу F
        double[] readNumbers = readFromFile(fileF);
        System.out.println("Вміст файлу F: " + Arrays.toString(readNumbers));

        // Вибір чисел більших за a
        ArrayList<Double> filtered = new ArrayList<>();
        for (double n : readNumbers) {
            if (n > a)
                filtered.add(n);
        }

        // файл G
        writeListToFile(fileG, filtered);

        // Перевірка вмісту G
        double[] gNumbers = readFromFile(fileG);
        System.out.println("Вміст файлу G: " + Arrays.toString(gNumbers));
    }

    //  Функція запису масиву double у бінарний файл
    public static void writeToFile(String filename, double[] array) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            for (double n : array)
                out.writeDouble(n);
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        }
    }

    //  Функція запису списку double у бінарний файл
    public static void writeListToFile(String filename, ArrayList<Double> list) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            for (double n : list)
                out.writeDouble(n);
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        }
    }

    //Функція зчитування масиву double з бінарного файлу
    public static double[] readFromFile(String filename) {
        double[] result = null;
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            int count = (int) (new File(filename).length() / Double.BYTES);
            result = new double[count];
            for (int i = 0; i < count; i++) {
                result[i] = in.readDouble();
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
        return result;
    }
}
