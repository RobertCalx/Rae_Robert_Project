package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void rectangleWithWidth2AndHeight4ShouldHaveArea8() {
        Rectangle rectangle = new Rectangle(2, 4);
        assertEquals(8, rectangle.area());
    }

    @Test
    public void rectangleWithWidth0AndHeight6ShouldHaveArea0() {
        Rectangle rectangle = new Rectangle(0, 6);
        assertEquals(0, rectangle.area());
    }

    @Test
    public void rectangleWithWidth2AndHeight2ShouldHavePerimeter8() {
        Rectangle rectangle = new Rectangle(2, 2);
        assertEquals(8, rectangle.perimeter());
    }

    @Test
    public void rectangleWithWidth4AndHeight2ShouldHavePerimeter12() {
        Rectangle rectangle = new Rectangle(4, 2);
        assertEquals(12, rectangle.perimeter());
    }

    @Test
    public void squareWithSideTwoShouldHaveAreaFour() {
        var square = Rectangle.createSquare(2);
        assertEquals(4, square.area());
    }
}
