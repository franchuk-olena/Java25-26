package Home.HW12;
public interface Student {
    void accept(StudentVisitor visitor);
    void addCredits(int credits);
    void addMoney(int money);
    boolean pay(int amount);
    int getCredits();
    int getRequiredCredits();
    int getMoney();
    boolean isExpelled();
    void expel();
}

