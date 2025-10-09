package Home.HW4;

public class Boots extends Gear {
    public Boots(String name, double weight, double protectionLevel) {
        super(name, weight, protectionLevel);
    }

    @Override
    public double calculateCost() {
        return 2500 * getProtectionLevel();
    }
}
