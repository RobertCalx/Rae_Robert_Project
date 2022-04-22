package edu.berkeley.aep;

import java.util.Objects;

public class Path {
    public final int cost;
    public final int hops;

    public Path(int costs, int hops) {
        this.cost = costs;
        this.hops = hops;
    }

    @Override
    public int hashCode(){
        return Objects.hash(cost, hops);
    }

    @Override
    public boolean equals(Object other){
        if (other == this) return true;
        if(!(other instanceof Path)) return false;
        return Integer.compare(((Path) other).hashCode(), this.hashCode()) == 0;
    }
    public boolean lessThan(Path champion) {
        return (this.cost < champion.cost || this.hops < champion.hops);
    }
}
