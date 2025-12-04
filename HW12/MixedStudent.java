package Home.HW12;
public class MixedStudent extends BaseStudent {
    public MixedStudent(int money, int requiredCredits) {
        super(money, requiredCredits);
    }

    @Override
    public void accept(StudentVisitor visitor) {
        visitor.visit(this);
    }
}
