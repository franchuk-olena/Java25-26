package Home.HW4;

public class Jacket extends Gear {
    public Jacket(String name, double weight, double protectionLevel) {
        super(name, weight, protectionLevel);
    }

    @Override
    public double calculateCost() {
        return 4000 * getProtectionLevel();
    }
}
