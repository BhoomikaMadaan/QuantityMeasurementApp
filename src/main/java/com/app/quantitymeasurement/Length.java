
// uc5 implementation

package com.app.quantitymeasurement;

/**
 * A generic class for representing and comparing lengths in different units.
 */
public class Length {

    private final double value;
    private final LengthUnit unit;

    /**
     * Enum representing different length units and their conversion factors.
     * Base unit = inches
     */
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),
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

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        this.value = value;
        this.unit = unit;
    }

    // Convert to base unit (inches)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // Generic comparison method
    private boolean compare(Length otherLength) {

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

    /**
     * Static utility method for conversion
     */
    public static double convert(double value,
            LengthUnit source,
            LengthUnit target) {

        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        double result = value * source.getConversionFactor()
                / target.getConversionFactor();

        return result;
    }

    /**
     * Instance conversion method
     */
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double convertedValue = convert(this.value, this.unit, targetUnit);

        return new Length(convertedValue, targetUnit);
    }

    // UC6 ADDITION TO METHOD ADD
    public Length add(Length otherLength) {

        if (otherLength == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        double thisBaseValue = this.value * this.unit.getConversionFactor();

        double otherBaseValue = otherLength.value * otherLength.unit.getConversionFactor();

        double sumInBaseUnit = thisBaseValue + otherBaseValue;

        double result = sumInBaseUnit / this.unit.getConversionFactor();

        return new Length(result, this.unit);
    }

    public static Length add(Length length1, Length length2) {

        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        return length1.add(length2);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public double getValue() {
        return value;
    }

    // Main method for standalone testing
    public static void main(String[] args) {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length convertedLength1 = length1.convertTo(LengthUnit.INCHES);

        System.out.println("Convert 1 FOOT to INCHES:");
        System.out.println(convertedLength1);

        Length length2 = new Length(3.0, LengthUnit.YARDS);
        Length convertedLength2 = length2.convertTo(LengthUnit.FEET);

        System.out.println("Convert 3 YARDS to FEET:");
        System.out.println(convertedLength2);

        Length length3 = new Length(36.0, LengthUnit.INCHES);
        Length convertedLength3 = length3.convertTo(LengthUnit.YARDS);

        System.out.println("Convert 36 INCHES to YARDS:");
        System.out.println(convertedLength3);
    }
}
