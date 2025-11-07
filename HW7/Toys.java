package Home.HW7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Toys implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public String name;
    public double price;
    public int minAge;
    public int maxAge;

    public Toys(String name, double price, int minAge, int maxAge) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return name + " (" + price + "), для віку " + minAge + "-" + maxAge + " років";
    }


    // --- Запис списку іграшок у файл ---
    public static void write(String out, List<Toys> toys) {
        try (var f = new ObjectOutputStream(new FileOutputStream(out))) {
            for (Toys t : toys) {
                f.writeObject(t);
            }
        } catch (IOException e) {
            throw new RuntimeException("Помилка запису у файл: " + e.getMessage());
        }
    }

    // --- Зчитування списку іграшок з файлу ---
    public static List<Toys> read(String inp) {
        List<Toys> toys = new ArrayList<>();
        try (var f = new ObjectInputStream(new FileInputStream(inp))) {
            while (true) {
                try {
                    toys.add((Toys) f.readObject());
                } catch (EOFException e) {
                    break; // кінець файлу
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Помилка читання файлу: " + e.getMessage());
        }
        return toys;
    }
}
