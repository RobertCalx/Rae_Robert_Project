package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Understands how to reach other airports
public class Airport {

    public static final int UNREACHABLE = -1;
    public static final Path UNREACHABLEPATH = new Path(-1,-1);
    public static final Path INF_PATH = new Path(Integer.MAX_VALUE, Integer.MAX_VALUE);

    List<Route> children = new ArrayList<>();

    public boolean canReach(Airport other) {
        return hopsTo(other) != UNREACHABLE;
    }

    public void addChild(Airport child, int cost) {
        children.add(new Route(child, cost));
    }

    public int hopsTo(Airport destination) {
        return hopsTo(destination, new HashSet<>(), Route.HOP_STRATEGY);
    }

    public int costTo(Airport destination) {
        return hopsTo(destination, new HashSet<>(), Route.COST_STRATEGY);
    }

    int hopsTo(Airport other, Set<Airport> visited, HopStrategy strategy) {
        if (!visited.add(this)) return UNREACHABLE;
        if (this.equals(other)) return 0;
        int champion = Integer.MAX_VALUE;
        for (var child: children) {
            int hops = child.hopsTo(other, new HashSet<>(visited), strategy);
            if (hops != UNREACHABLE && hops < champion) {
                champion = hops;
            }
        }
        return champion == Integer.MAX_VALUE ? UNREACHABLE : champion;
    }

    Path pathTo(Airport other, Set<Airport> visited) {
        if (!visited.add(this)) return UNREACHABLEPATH;
        if (this.equals(other)) return new Path(0, 0);
        Path champion = INF_PATH;
        for (var child : children) {
            int hops = child.hopsTo(other, new HashSet<>(visited), Route.HOP_STRATEGY);
            int cost = child.hopsTo(other, new HashSet<>(visited), Route.COST_STRATEGY);
            Path current = new Path(cost, hops);
            if (!current.equals(UNREACHABLEPATH) && current.lessThan(champion)) {
                champion = current;
            }
        }
        return champion == INF_PATH ? UNREACHABLEPATH : champion;
    }

    public Path pathTo(Airport other) {
        return this.pathTo(other, new HashSet<>());
    }
}
