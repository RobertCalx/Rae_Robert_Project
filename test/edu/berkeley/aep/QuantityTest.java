package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuantityTest {
    @Test
    public void twelveInchesShouldEqualOneFoot() {
        var twelveInches = new ArithmeticQuantity(12, Unit.INCH);
        var oneFoot = new ArithmeticQuantity(1, Unit.FOOT);
        assertEquals(twelveInches, oneFoot);
    }

    @Test
    public void threeFeetShouldEqualOneYard() {
        var threeFeet = new ArithmeticQuantity(3, Unit.FOOT);
        var oneYard = new ArithmeticQuantity(1, Unit.YARD);
        assertEquals(threeFeet, oneYard);
    }

    @Test
    public void oneMileShouldEqual1760yards() {
        var one760Yard = new ArithmeticQuantity(1760, Unit.YARD);
        var oneMile = new ArithmeticQuantity(1, Unit.MILE);
        assertEquals(one760Yard, oneMile);
    }

    @Test
    public void oneTablespoonShouldEqualThreeTeaspoons() {
        var oneTbsp = new ArithmeticQuantity(1, Unit.TBSP);
        var threeTsp = new ArithmeticQuantity(3, Unit.TSP);
        assertEquals(oneTbsp, threeTsp);
    }

    @Test
    public void oneOzShouldEqualTwoTbsp() {
        var oneOz = new ArithmeticQuantity(1, Unit.OZ);
        var threeTsp = new ArithmeticQuantity(2, Unit.TBSP);
        assertEquals(oneOz, threeTsp);
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        var twoInches = new ArithmeticQuantity(2, Unit.INCH);
        var fourInches = new ArithmeticQuantity(4, Unit.INCH);
        assertEquals(fourInches, twoInches.add(twoInches));
    }

    @Test
    public void twoTablespoonsPlusOneOzShouldEqualTwelveTsp() {
        var twoTbsp = new ArithmeticQuantity(2, Unit.TBSP);
        var oneOz = new ArithmeticQuantity(1, Unit.OZ);
        var twelveTsp = new ArithmeticQuantity(12, Unit.TSP);
        assertEquals(twelveTsp, twoTbsp.add(oneOz));
    }

    @Test
    public void oneHundredCelsiusShouldEqual212F() {
        var oneHundredCelsius = new ScaledQuantity(100, Unit.CELSIUS);
        var twoHundredTwelveFahrenheit = new ScaledQuantity(212, Unit.FAHRENHEIT);
        assertEquals(oneHundredCelsius, twoHundredTwelveFahrenheit);
    }

    @Test
    public void zeroCelsiusShouldEqual32F() {
        var zeroCelsius = new ScaledQuantity(0, Unit.CELSIUS);
        var thirtyTwoFahrenheit = new ScaledQuantity(32, Unit.FAHRENHEIT);
        assertEquals(zeroCelsius, thirtyTwoFahrenheit);
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotBeAbleToAddIncomparableUnits() {
        var twoTbsp = new ArithmeticQuantity(2, Unit.TBSP);
        var oneInch = new ArithmeticQuantity(1, Unit.INCH);
        try {
            assertEquals(new ArithmeticQuantity(1, Unit.OZ), twoTbsp.add(oneInch));
        } catch (Exception e) {
            throw new RuntimeException("I couldn't do anything about this!", e);
        }
    }

    @Test
    public void oneOzShouldBeBetterThanFourTeaspoons() {
        var fourTsp = new ScaledQuantity(4, Unit.TSP);
        var oneOz = new ScaledQuantity(1, Unit.OZ);
        assertTrue(oneOz.betterThan(fourTsp));
    }
}
