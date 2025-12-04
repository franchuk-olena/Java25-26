package Home.HW12;

public class ParentMoneyVisitor implements StudentVisitor {
    private final int amount;

    public ParentMoneyVisitor(int amount) {
        this.amount = amount;
    }

    @Override
    public void visit(HumanitarianStudent student) {
        student.addMoney(amount);
    }

    @Override
    public void visit(NaturalStudent student) {
        student.addMoney(amount);
    }

    @Override
    public void visit(MixedStudent student) {
        student.addMoney(amount);
    }
}
