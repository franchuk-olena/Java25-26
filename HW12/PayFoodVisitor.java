package Home.HW12;

public class PayFoodVisitor implements StudentVisitor {
    private final int amount;

    public PayFoodVisitor(int amount) {
        this.amount = amount;
    }

    @Override
    public void visit(HumanitarianStudent student) {
        student.pay(amount);
    }

    @Override
    public void visit(NaturalStudent student) {
        student.pay(amount);
    }

    @Override
    public void visit(MixedStudent student) {
        student.pay(amount);
    }
}

