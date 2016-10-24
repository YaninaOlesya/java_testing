package ru.java_testing.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Олеся on 24.10.2016.
 */
public class PointTests {

    @Test
    public void testDistance1() {
        Point p1 = new Point(2, 0);
        Point p2 = new Point(-2, 0);
        Assert.assertEquals(p1.distance(p2), 4.0);
    }

    @Test
    public void testDistance2() {
        Point p1 = new Point(1, -1);
        Point p2 = new Point(2, 3);
        Assert.assertEquals(p1.distance(p2), Math.sqrt(17.0));
    }

    @Test
    public void testDistance3() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Assert.assertEquals(p1.distance(p2), 0.0);
    }
}
