package edu.berkeley.aep;

// Understands a measurement in a given unit
public class ArithmeticQuantity extends ScaledQuantity {

    public ArithmeticQuantity(int amount, Unit unit) {
        super(amount, unit);
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        if (!unit.isComparableTo(other.unit))
            throw new RuntimeException("Cannot compare a " + unit + " to a " + other.unit);
        var otherAmount = other.unit.convertTo(this.unit, other.amount);
        return new ArithmeticQuantity(amount + otherAmount, unit);
    }
}
