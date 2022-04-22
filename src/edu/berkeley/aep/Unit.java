package edu.berkeley.aep;

// Understands how to convert between measurements of different types
public enum Unit {
    INCH(1, UnitType.LENGTH, 0),
    FOOT(12, UnitType.LENGTH, 0),
    YARD(36, UnitType.LENGTH, 0),
    MILE(36 * 1760, UnitType.LENGTH, 0),
    TSP(1, UnitType.VOLUME, 0),
    TBSP(3, UnitType.VOLUME, 0),
    OZ(6, UnitType.VOLUME, 0),
    CUP(48, UnitType.VOLUME, 0),
    CELSIUS(9, UnitType.TEMPERATURE, 0),
    FAHRENHEIT(5, UnitType.TEMPERATURE, 32);

    private final int inBaseUnits;
    private final UnitType unitType;
    private final int offset;

    Unit(int inBaseUnits, UnitType length, int offset) {
        this.inBaseUnits = inBaseUnits;
        this.unitType = length;
        this.offset = offset;
    }

    private enum UnitType {
        VOLUME, LENGTH, TEMPERATURE
    }

    public int convertTo(Unit to, int amount) {
        return ((amount - offset) * inBaseUnits / to.inBaseUnits) + to.offset;
    }

    public boolean isComparableTo(Unit other) {
        return unitType == other.unitType;
    }
}
