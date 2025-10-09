package Home.HW4;

public class Helmet extends Gear {
    public Helmet(String name, double weight, double protectionLevel) {
        super(name, weight, protectionLevel);
    }

    @Override
    public double calculateCost() {
        // Візьмемо: базова ціна 3000 грн × коефіцієнт захисту
        return 3000 * getProtectionLevel();
    }
}
