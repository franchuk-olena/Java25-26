package Home.HW12;
public class HumanitarianStudent extends BaseStudent {
    public HumanitarianStudent(int money, int requiredCredits) {
        super(money, requiredCredits);
    }

    @Override
    public void accept(StudentVisitor visitor) {
        visitor.visit(this);
    }
}

