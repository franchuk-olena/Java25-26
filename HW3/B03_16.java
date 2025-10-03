package Home.HW3;

import java.util.Arrays;

class Product {
    private String name;
    private double price;
    private int shelfLife; // термін зберігання у днях
    private int quantity;

    public Product(String name, double price, int shelfLife, int quantity) {
        this.name = name;
        this.price = price;
        this.shelfLife = shelfLife;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price + " | Shelf life: " + shelfLife + " days | Quantity: " + quantity;
    }
}

public class B03_16{
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 20.5, 7, 10);
        products[1] = new Product("Bread", 15.0, 3, 20);
        products[2] = new Product("Cheese", 50.0, 30, 5);
        products[3] = new Product("Butter", 45.0, 20, 6);
        products[4] = new Product("Yogurt", 18.0, 5, 12);

        // Сортування за ціною
        Product[] sortedByPrice = sortByPrice(products);
        System.out.println("Products sorted by price:");
        for (Product p : sortedByPrice) {
            System.out.println(p);
        }

        // Фільтрація за назвою та терміном зберігання
        Product[] filteredProducts = filterByNameAndShelfLife(products, "Yogurt", 6);
        System.out.println("\nProducts with name 'Yogurt' and shelf life <= 6 days:");
        for (Product p : filteredProducts) {
            System.out.println(p);
        }
    }

    // Метод сортування за ціною
    public static Product[] sortByPrice(Product[] products) {
        Product[] sorted = Arrays.copyOf(products, products.length);
        Arrays.sort(sorted, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        return sorted;
    }

    // Метод фільтрації за назвою і терміном зберігання
    public static Product[] filterByNameAndShelfLife(Product[] products, String name, int maxShelfLife) {
        return Arrays.stream(products)
                .filter(p -> p.getName().equalsIgnoreCase(name) && p.getShelfLife() <= maxShelfLife)
                .toArray(Product[]::new);
    }
}
