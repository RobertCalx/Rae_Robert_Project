package edu.berkeley.aep;

import java.util.HashSet;

// Understands the cost of travelling between two airports
public class Route {
    private final Airport child;
    private final int cost;

    public static HopStrategy HOP_STRATEGY = route -> 1;
    public static HopStrategy COST_STRATEGY = route -> route.cost;

    public Route(Airport child, int cost) {
        this.child = child;
        this.cost = cost;
    }

    public int hopsTo(Airport other, HashSet<Airport> airports, HopStrategy strategy) {
        int hopsTo = child.hopsTo(other, airports, strategy);
        if (hopsTo == Airport.UNREACHABLE) return Airport.UNREACHABLE;
        return hopsTo + strategy.cost(this);
    }
}
