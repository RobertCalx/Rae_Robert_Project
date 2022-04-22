package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Understands how to compare objects and find the best
public class BesterTest {
    @Test
    public void bestOfFourTeaspoonsAndOneOzShouldBeOneOz() {
        var fourTsp = new ArithmeticQuantity(4, Unit.TSP);
        var oneOz = new ArithmeticQuantity(1, Unit.OZ);
        var bester = new Bester(fourTsp, oneOz);
        assertEquals(oneOz, bester.best());
    }

    @Test
    public void bestOfHalfAndQuarterShouldBeHalf() {
        var half = new Chance(0.5);
        var quarter = new Chance(0.25);
        var bester = new Bester(half, quarter);
        assertEquals(half, bester.best());
    }

    @Test(expected = NullPointerException.class)
    public void passingNullIntoBesterShouldFail() {
        var bester = new Bester(null, null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void passingEmptyListIntoBesterShouldFail() {
        var bester = new Bester();
    }
}
