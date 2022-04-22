package edu.berkeley.aep;

public class ScaledQuantity implements Bestable<ScaledQuantity> {
    protected final int amount;
    protected final Unit unit;

    public ScaledQuantity(int amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        ScaledQuantity otherQuantity = (ScaledQuantity) other;
        return otherQuantity.convert(this.unit) == amount;
    }

    int convert(Unit unit) {
        return this.unit.convertTo(unit, amount);
    }

    @Override
    public String toString() {
        return amount + " " + unit;
    }

    @Override
    public boolean betterThan(ScaledQuantity other) {
        return amount > other.convert(unit);
    }
}
