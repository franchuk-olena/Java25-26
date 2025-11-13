package Home.HW8;

import java.util.PriorityQueue;

class Point implements Comparable<Point> {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Відстань до початку координат
    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    // Сортування за відстанню
    @Override
    public int compareTo(Point other) {
        return Double.compare(this.distanceToOrigin(), other.distanceToOrigin());
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ") = " + String.format("%.2f", distanceToOrigin());
    }
}

public class B08_04 {
    public static void main(String[] args) {
        Point[] points = {
                new Point(1, 2),
                new Point(2, 3),
                new Point(0, 0),
                new Point(-0.5, -0.5),
                new Point(2, 2)
        };

        // PriorityQueue сортує точки за відстанню
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (Point p : points) {
            pq.add(p);
        }

        System.out.println("Точки у порядку зростання відстані до початку координат:");
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            System.out.println(p);
        }
    }
}
