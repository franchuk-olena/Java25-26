package Home.HW12;

public abstract class BaseStudent implements Student {
    protected int credits;
    protected int money;
    protected final int requiredCredits;
    protected boolean expelled;

    public BaseStudent(int money, int requiredCredits) {
        this.money = money;
        this.requiredCredits = requiredCredits;
        this.credits = 0;
        this.expelled = false;
    }

    @Override
    public void addCredits(int credits) {
        this.credits += credits;
    }

    @Override
    public void addMoney(int money) {
        this.money += money;
    }

    @Override
    public boolean pay(int amount) {
        if (money >= amount) {
            money -= amount;
            return true;
        } else {
            expelled = true;
            return false;
        }
    }

    @Override
    public int getCredits() {
        return credits;
    }

    @Override
    public int getRequiredCredits() {
        return requiredCredits;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public boolean isExpelled() {
        return expelled;
    }

    @Override
    public void expel() {
        expelled = true;
    }

    @Override
    public abstract void accept(StudentVisitor visitor);
}
