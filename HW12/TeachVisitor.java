package Home.HW12;

public class TeachVisitor implements StudentVisitor {
    private final String disciplineType;
    private final int credits;

    public TeachVisitor(String disciplineType, int credits) {
        this.disciplineType = disciplineType;
        this.credits = credits;
    }

    @Override
    public void visit(HumanitarianStudent student) {
        if ("humanitarian".equals(disciplineType)) {
            student.addCredits(credits);
        }
    }

    @Override
    public void visit(NaturalStudent student) {
        if ("natural".equals(disciplineType)) {
            student.addCredits(credits);
        }
    }

    @Override
    public void visit(MixedStudent student) {
        student.addCredits(credits);
    }
}

