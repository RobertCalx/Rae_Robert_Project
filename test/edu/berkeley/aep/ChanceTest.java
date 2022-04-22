package edu.berkeley.aep;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ChanceTest {

    @Test
    public void probabilityOfDieThrowShouldNotBeTheSameAsProbabilityOfCoinToss() {
        var dieThrow = new Chance(1 / 6);
        var coinToss = new Chance(0.5);
        assertFalse(dieThrow.equals(coinToss));
    }

    @Test
    public void twoCoinTossesShouldHaveEqualProbability() {
        var coinToss = new Chance(0.5);
        var anotherCoinToss = new Chance(0.5);
        assertEquals(coinToss, anotherCoinToss);
    }

    @Test
    public void notOfProbabilityOneSixthShouldBeFiveSixths() {
        var dieRoll = new Chance(1d / 6d);
        var dieRollComplement = new Chance(5d / 6d);
        assertEquals(dieRollComplement, dieRoll.not());
    }

    @Test
    public void zeroPoint5And0point5ShouldBe0point25() {
        var dieRoll = new Chance(0.5);
        assertEquals(new Chance(0.25), dieRoll.and(dieRoll));
    }

    @Test
    public void zeroPoint5Or0point5ShouldBe0point75() {
        var dieRoll = new Chance(0.5);
        assertEquals(new Chance(0.75), dieRoll.or(dieRoll));
    }

    @Test
    public void valueObjectShouldOverrideHashcode() {
        var coinToss = new Chance(0.5);
        var coinTosses = new HashMap<Chance, String>();
        coinTosses.put(coinToss, "Heads!");
        assertEquals("Heads!", coinTosses.get(new Chance(0.5)));
    }

    @Test
    public void halfShouldBeBetterThanQuarter() {
        var half = new Chance(0.5);
        var quarter = new Chance(0.25);
        assertTrue(half.betterThan(quarter));
    }
}
