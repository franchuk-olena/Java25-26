package Home.HW12;

public interface StudentVisitor {
    void visit(HumanitarianStudent student);
    void visit(NaturalStudent student);
    void visit(MixedStudent student);
}
