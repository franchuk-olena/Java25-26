package Home.HW12;

public class NaturalStudent extends BaseStudent {
    public NaturalStudent(int money, int requiredCredits) {
        super(money, requiredCredits);
    }

    @Override
    public void accept(StudentVisitor visitor) {
        visitor.visit(this);
    }
}
