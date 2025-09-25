package Home.HW2;

public class B02_17d {
    public static double sumTerms(double x, double epsilon) {
        double sum = 0.0;
        int k = 0;
        while (true) {
            double term = Math.pow(-1, k) * Math.pow(x, 2*k);
            if (Math.abs(term) > epsilon) {
                k++;
                continue;
            }
            if (term == 0) break;
            sum += term;
            k++;
        }
        return sum;
    }

    public static void main(String[] args) {
        double x = 0.5;
        double epsilon = 0.01;

        double result = sumTerms(x, epsilon);
        System.out.println("Сума доданків ≤ ε = " + result);
    }
}
