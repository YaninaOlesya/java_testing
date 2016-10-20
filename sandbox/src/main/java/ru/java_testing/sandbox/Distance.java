package ru.java_testing.sandbox;

/**
 * Created by Олеся on 20.10.2016.
 */
public class Distance {

    public static void main(String[] args) {

        Point p1 = new Point(1, 0);
        Point p2 = new Point(0, -5);

        //пример использования функции из запускаемого класса
        System.out.println("Расстояние между точками: (" + p1.x + ", " + p1.y + ") и (" + p2.x + ", " + p2.y + ") = " + distance(p1, p2));

        //пример использования метода класса Point
        System.out.println("Расстояние между точками: (" + p1.x + ", " + p1.y + ") и (" + p2.x + ", " + p2.y + ") = " + p1.distance(p2));
    }

    public static double distance(Point p1, Point p2) {
        double cathetus1 = p1.x - p2.x; //длина первого катета
        double cathetus2 = p1.y - p2.y; //длина второго катета
        return Math.sqrt(Math.pow(cathetus1, 2) + Math.pow(cathetus2, 2));

    }
}
