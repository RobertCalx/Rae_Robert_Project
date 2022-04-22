package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Understands a four-sided figure with sides at right angles
public class Rectangle {
    private final int length;
    private final int width;

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int area() {
        return length * width;
    }

    public int perimeter() {
        return 2 * length + 2 * width;
    }
}
