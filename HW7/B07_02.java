package Home.HW7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B07_02 {

    public static void main(String[] args) {
        String inp = "src/Home/HW7/toys.dat";          // файл F
        String out = "src/Home/HW7/toys_for_age.dat";  // файл G

        // 1️⃣ Створення початкового списку іграшок
        List<Toys> toys = List.of(
                new Toys("М'яч", 150.0, 3, 10),
                new Toys("Лялька", 300.0, 4, 9),
                new Toys("Конструктор LEGO", 1200.0, 6, 14),
                new Toys("Пірамідка", 100.0, 1, 3),
                new Toys("Настільна гра", 500.0, 8, 16)
        );

        // 2️⃣ Запис у файл F
        Toys.write(inp, toys);

        // 3️⃣ Зчитування файлу F
        List<Toys> allToys = Toys.read(inp);
        System.out.println("\nУсі іграшки у файлі F:");
        allToys.forEach(System.out::println);

        // 4️⃣ Введення віку дитини
        Scanner sc = new Scanner(System.in);
        System.out.print("\nВведіть вік дитини: ");
        int childAge = sc.nextInt();

        // 5️⃣ Вибір іграшок для цього віку
        List<Toys> suitable = new ArrayList<>();
        for (Toys t : allToys) {
            if (childAge >= t.minAge && childAge <= t.maxAge) {
                suitable.add(t);
            }
        }

        // 6️⃣ Запис у файл G
        Toys.write(out, suitable);

        // 7️⃣ Виведення результатів
        System.out.println("\nІграшки, що підходять для віку " + childAge + ":");
        if (suitable.isEmpty()) {
            System.out.println("Немає відповідних іграшок.");
        } else {
            suitable.forEach(System.out::println);
        }
    }
}
