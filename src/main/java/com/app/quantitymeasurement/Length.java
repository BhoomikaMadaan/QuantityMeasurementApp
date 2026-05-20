package com.app.quantitymeasurement;

public class Length {

    private final double value;
    private final LengthUnit unit;

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

    private double convertToBaseUnit() {

        return unit.convertToBaseUnit(value);
    }

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

    public static double convert(
            double value,
            LengthUnit source,
            LengthUnit target) {

        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        double baseValue = source.convertToBaseUnit(value);

        return target.convertFromBaseUnit(baseValue);
    }

    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double convertedValue = convert(this.value, this.unit, targetUnit);

        return new Length(convertedValue, targetUnit);
    }

    public Length add(Length otherLength) {

        if (otherLength == null) {
            throw new IllegalArgumentException(
                    "Length cannot be null");
        }

        double thisBaseValue = this.unit.convertToBaseUnit(this.value);

        double otherBaseValue = otherLength.unit.convertToBaseUnit(otherLength.value);

        double sumInBaseUnit = thisBaseValue + otherBaseValue;

        double result = this.unit.convertFromBaseUnit(sumInBaseUnit);

        return new Length(result, this.unit);
    }

    public static Length add(
            Length length1,
            Length length2) {

        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException(
                    "Length cannot be null");
        }

        return length1.add(length2);
    }

    public Length add(
            Length length,
            LengthUnit targetUnit) {

        return addAndConvert(length, targetUnit);
    }

    private Length addAndConvert(
            Length length,
            LengthUnit targetUnit) {

        if (length == null || targetUnit == null) {
            throw new IllegalArgumentException(
                    "Length or target unit cannot be null");
        }

        double thisBaseValue = this.convertToBaseUnit();

        double otherBaseValue = length.convertToBaseUnit();

        double totalBaseValue = thisBaseValue + otherBaseValue;

        double convertedValue = targetUnit.convertFromBaseUnit(totalBaseValue);

        return new Length(convertedValue, targetUnit);
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
}