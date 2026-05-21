package com.app.quantitymeasurement;

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    /**
     * Constructor
     */
    public QuantityWeight(
            double value,
            WeightUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Weight unit cannot be null");
        }

        if (Double.isNaN(value)
                || Double.isInfinite(value)) {

            throw new IllegalArgumentException(
                    "Invalid weight value");
        }

        this.value = value;
        this.unit = unit;
    }

    /**
     * Convert current weight to base unit (KILOGRAM)
     */
    private double convertToBaseUnit() {

        return unit.convertToBaseUnit(value);
    }

    /**
     * Internal comparison helper
     */
    private boolean compare(
            QuantityWeight otherWeight) {

        return Double.compare(
                this.convertToBaseUnit(),
                otherWeight.convertToBaseUnit()) == 0;
    }

    /**
     * Equality check
     */
    @Override
    public boolean equals(Object obj) {

        // Same reference
        if (this == obj)
            return true;

        // Null check
        if (obj == null)
            return false;

        // Category type safety
        if (getClass() != obj.getClass())
            return false;

        QuantityWeight other = (QuantityWeight) obj;

        return compare(other);
    }

    /**
     * Convert to target unit
     */
    public QuantityWeight convertTo(
            WeightUnit targetUnit) {

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double baseValue = this.convertToBaseUnit();

        double convertedValue = targetUnit.convertFromBaseUnit(
                baseValue);

        return new QuantityWeight(
                convertedValue,
                targetUnit);
    }

    /**
     * UC6-style addition
     * Result in first operand's unit
     */
    public QuantityWeight add(
            QuantityWeight otherWeight) {

        if (otherWeight == null) {

            throw new IllegalArgumentException(
                    "Weight cannot be null");
        }

        double thisBaseValue = this.convertToBaseUnit();

        double otherBaseValue = otherWeight.convertToBaseUnit();

        double totalBaseValue = thisBaseValue + otherBaseValue;

        double result = this.unit.convertFromBaseUnit(
                totalBaseValue);

        return new QuantityWeight(
                result,
                this.unit);
    }

    /**
     * UC7-style addition
     * Explicit target unit
     */
    public QuantityWeight add(
            QuantityWeight otherWeight,
            WeightUnit targetUnit) {

        if (otherWeight == null
                || targetUnit == null) {

            throw new IllegalArgumentException(
                    "Weight or target unit cannot be null");
        }

        double thisBaseValue = this.convertToBaseUnit();

        double otherBaseValue = otherWeight.convertToBaseUnit();

        double totalBaseValue = thisBaseValue + otherBaseValue;

        double convertedValue = targetUnit.convertFromBaseUnit(
                totalBaseValue);

        return new QuantityWeight(
                convertedValue,
                targetUnit);
    }

    @Override
    public String toString() {

        return String.format(
                "%.2f %s",
                value,
                unit);
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }
}