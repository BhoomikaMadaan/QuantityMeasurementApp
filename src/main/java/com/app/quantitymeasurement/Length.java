package com.app.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // Enum for units
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),
        // UC4 ADDITION:updated enum to add for yards and centimeters
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // Generic comparison method
    public boolean compare(Length otherLength) {

        return Double.compare(
                this.convertToBaseUnit(),
                otherLength.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Length other = (Length) obj;

        return compare(other);
    }
}