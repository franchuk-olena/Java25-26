package Home.HW4;
import java.util.*;
public class MotorcyclistApp {
    public static void main(String[] args) {
        List<Gear> equipment = new ArrayList<>();
        equipment.add(new Helmet("Шолом", 1.2, 0.9));
        equipment.add(new Jacket("Куртка", 3.5, 0.8));
        equipment.add(new Gloves("Рукавички", 0.5, 0.6));
        equipment.add(new Boots("Черевики", 2.0, 0.7));
        equipment.add(new Pants("Штани", 2.8, 0.75));

        System.out.println("=== Екіпірування мотоцикліста ===");
        for (Gear g : equipment) {
            System.out.println(g);
        }

        double totalCost = 0;
        for (Gear g : equipment) {
            totalCost += g.calculateCost();
        }
        System.out.printf("\nЗагальна вартість екіпіровки: %.2f грн\n", totalCost);

        // Сортування за вагою
        Collections.sort(equipment);
        System.out.println("\n=== Сортування за вагою ===");
        for (Gear g : equipment) {
            System.out.println(g);
        }

        // Пошук за діапазоном коефіцієнта захисту
        double minProtection = 0.7;
        double maxProtection = 0.85;
        System.out.printf("\n=== Елементи з коефіцієнтом захисту від %.2f до %.2f ===\n", minProtection, maxProtection);
        for (Gear g : equipment) {
            if (g.getProtectionLevel() >= minProtection && g.getProtectionLevel() <= maxProtection) {
                System.out.println(g);
            }
        }
    }
}
