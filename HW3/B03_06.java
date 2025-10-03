package Home.HW3;

class Quadrilateral {
    private double a, b, c, d; // сторони чотирикутника

    public Quadrilateral(double a, double b, double c, double d) {
        this.a = a; this.b = b; this.c = c; this.d = d;
    }

    public double getPerimeter() {
        return a + b + c + d;
    }

    private boolean equalsDouble(double x, double y) {
        return Math.abs(x - y) < 1e-6;
    }

    public String getType() {
        // Квадрат: всі сторони рівні
        if (equalsDouble(a, b) && equalsDouble(b, c) && equalsDouble(c, d)) {
            return "Square";
        }
        // Прямокутник: протилежні сторони рівні
        if (equalsDouble(a, c) && equalsDouble(b, d)) {
            return "Rectangle";
        }
        // Ромб: всі сторони рівні, але не квадрат
        if (equalsDouble(a, b) && equalsDouble(b, c) && equalsDouble(c, d)) {
            return "Rhombus";
        }
        return "Arbitrary Quadrilateral";
    }
}

public class B03_06 {
    public static void main(String[] args) {
        Quadrilateral[] quads = new Quadrilateral[5];

        quads[0] = new Quadrilateral(5, 5, 5, 5); // квадрат
        quads[1] = new Quadrilateral(4, 6, 4, 6); // прямокутник
        quads[2] = new Quadrilateral(3, 3, 3, 3); // квадрат (можна вважати ромбом)
        quads[3] = new Quadrilateral(2, 3, 4, 5); // довільний
        quads[4] = new Quadrilateral(6, 6, 6, 6); // квадрат

        countTypes(quads);
        Quadrilateral maxPerimeterQuad = getMaxPerimeter(quads);
        System.out.println("Quadrilateral with maximum perimeter has perimeter: " + maxPerimeterQuad.getPerimeter());
    }

    public static void countTypes(Quadrilateral[] quads) {
        int squares = 0, rectangles = 0, rhombuses = 0, arbitrary = 0;

        for (Quadrilateral q : quads) {
            switch (q.getType()) {
                case "Square": squares++; break;
                case "Rectangle": rectangles++; break;
                case "Rhombus": rhombuses++; break;
                default: arbitrary++; break;
            }
        }

        System.out.println("Squares: " + squares);
        System.out.println("Rectangles: " + rectangles);
        System.out.println("Rhombuses: " + rhombuses);
        System.out.println("Arbitrary Quadrilaterals: " + arbitrary);
    }

    public static Quadrilateral getMaxPerimeter(Quadrilateral[] quads) {
        Quadrilateral max = quads[0];
        for (Quadrilateral q : quads) {
            if (q.getPerimeter() > max.getPerimeter()) max = q;
        }
        return max;
    }
}
