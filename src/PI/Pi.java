package PI;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

public class Pi {

    private static final int Size = 10000000;//к-ть точок, на основі яких будемо генерувати

    static boolean IsInside(double x, double y) {//ф-я для перевірки, чи знаходиться точка всередині кола
        double l = Math.sqrt(x * x + y * y);
        return l <= 1;
    }

    static double calc(List<Point> points) {//ф-я підрахування  числа Пі
        double pi = 0;
        int inside = 0;

        for (Point p : points) {
            if (IsInside(p.X(), p.Y())) {
                inside++;
            }
        }

        pi = inside / (points.size() * 1.0) * 4.0;
        return pi;
    }

    static Point generatePoint() { //ф-я генерациї точки
        return new Point(Math.random(), Math.random());
    }

    public static void main(String[] args) {

        Instant t1 = Instant.now();
        //Створюємо і заповнюємо список точок
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < Size; i++) {
            Point p = generatePoint();
            points.add(p);
        }

        double pi = calc(points);//викл. ф-ю обчислення числа Пі
        Instant t2 = Instant.now();
        Duration duration = Duration.between(t1, t2);//час вик-ня

        System.out.println(pi+"   for    "+ duration);//виводимо зн-ня Пі
    }
}
