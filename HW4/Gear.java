package Home.HW4;

public abstract class Gear implements Comparable<Gear> {
    private String name;
    private double weight;             // кг
    private double protectionLevel;    // 0..1

    public Gear(String name, double weight, double protectionLevel) {
        this.name = name;
        this.weight = weight;
        this.protectionLevel = protectionLevel;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getProtectionLevel() {
        return protectionLevel;
    }

    public abstract double calculateCost();

    @Override
    public int compareTo(Gear other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return String.format("%s (вага: %.2f кг, захист: %.2f, вартість: %.2f грн)",
                name, weight, protectionLevel, calculateCost());
    }
}
