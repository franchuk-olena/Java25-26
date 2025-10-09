package Home.HW4;

public class Pants extends Gear {
    public Pants(String name, double weight, double protectionLevel) {
        super(name, weight, protectionLevel);
    }

    @Override
    public double calculateCost() {
        return 3500 * getProtectionLevel();
    }
}
