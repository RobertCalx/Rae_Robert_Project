package edu.berkeley.aep;

import java.util.Arrays;
import java.util.List;

public class Bester {
    private final List<Bestable> quantities;

    public Bester(Bestable... quantities) {
        this.quantities = Arrays.asList(quantities);
        if (this.quantities.contains(null)) {
            throw new NullPointerException("List should not contain null values");
        }
        if (this.quantities.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("List should not be empty");
        }
    }

    public Bestable best() {
        var champion = quantities.get(0);
        for (var challenger : quantities) {
            if (challenger.betterThan(champion)) {
                champion = challenger;
            }
        }
        return champion;
    }
}
