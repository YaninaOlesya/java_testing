package ru.java_testing.sandbox;

/**
 * Created by Олеся on 20.10.2016.
 */
public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {
        double cathetus1 = this.x - p2.x;
        double cathetus2 = this.y - p2.y;
        return Math.sqrt(Math.pow(cathetus1, 2) + Math.pow(cathetus2, 2));

    }
}
