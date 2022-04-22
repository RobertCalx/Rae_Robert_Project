package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirportTest {

    static Airport a = new Airport();
    static Airport b = new Airport();
    static Airport c = new Airport();
    static Airport d = new Airport();
    static Airport e = new Airport();
    static Airport f = new Airport();
    static Airport g = new Airport();
    static Airport h = new Airport();

    static {
        h.addChild(b, 87);
        b.addChild(a, 179);
        a.addChild(f, 72);
        b.addChild(c, 402);
        c.addChild(d, 126);
        c.addChild(e, 749);
        c.addChild(e, 320);
        d.addChild(e, 79);
        e.addChild(b, 312);
    }

    @Test
    public void shouldBeAbleToReachAirportFromSelf() {
        var a = new Airport();
        assertTrue(a.canReach(a));
    }

    @Test
    public void shouldNotBeAbleToReachAirportFromUnrelated() {
        var a = new Airport();
        var b = new Airport();
        assertFalse(a.canReach(b));
    }

    @Test
    public void shouldBeAbleToReachCFromH() {
        assertTrue(h.canReach(c));
    }

    @Test
    public void shouldNotBeAbleToReachGFromC() {
        assertFalse(c.canReach(g));
    }

    @Test
    public void hopsFromHToHShouldBeZero() {
        assertEquals(0, h.hopsTo(h));
    }

    @Test
    public void hopsFromHToCShouldBeTwo() {
        assertEquals(2, h.hopsTo(c));
    }

    @Test
    public void gShouldBeUnreachableFromC() {
        assertEquals(Airport.UNREACHABLE, c.hopsTo(g));
    }

    @Test
    public void eShouldBeOneHopFromC() {
        assertEquals(1, c.hopsTo(e));
    }

    @Test
    public void costFromAirportToSelfShouldBeZero() {
        assertEquals(0, c.costTo(c));
    }

    @Test
    public void costFromHToBShouldBe87() {
        assertEquals(87, h.costTo(b));
    }

    @Test
    public void pathReturnsCostOf87(){
        Path pathFromHToB = h.pathTo(b);
        assertEquals(87, pathFromHToB.cost);
    }

    @Test
    public void pathFromHToBEqualsItself(){
        Path path1 = h.pathTo(b);
        Path path2 = h.pathTo(b);
        assertEquals(path1, path2);
    }

    @Test
    public void pathReturnsHopsOf1(){
        Path pathFromHToB = h.pathTo(b);
        assertEquals(1, pathFromHToB.hops);
    }

    @Test
    public void pathReturnsCostOf607(){
        Path pathFromBToE = b.pathTo(e);
        assertEquals(607, pathFromBToE.cost);
    }

    @Test
    public void pathReturnsHopsOf2(){
        Path pathFromBToE = b.pathTo(e);
        assertEquals(2, pathFromBToE.hops);
    }
}

