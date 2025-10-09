package Home.HW4;

public class Gloves extends Gear {
    public Gloves(String name, double weight, double protectionLevel) {
        super(name, weight, protectionLevel);
    }

    @Override
    public double calculateCost() {
        return 1000 * getProtectionLevel();
    }
}
