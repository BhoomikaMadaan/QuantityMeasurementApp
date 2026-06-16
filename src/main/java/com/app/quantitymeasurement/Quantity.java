package com.app.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;

    private final U unit;

    /**
     * Constructor
     */
    public Quantity(
            double value,
            U unit) {

        if (unit == null) {

            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        if (Double.isNaN(value)
                || Double.isInfinite(value)) {

            throw new IllegalArgumentException(
                    "Invalid quantity value");
        }

        this.value = value;
        this.unit = unit;
    }

    /**
     * Convert current quantity
     * to base unit
     */
    private double convertToBaseUnit() {

        return unit.convertToBaseUnit(value);
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

        // Same class check
        if (getClass() != obj.getClass())
            return false;

        Quantity<?> other = (Quantity<?>) obj;

        // Cross-category prevention
        if (this.unit.getClass() != other.unit.getClass()) {

            return false;
        }

        return Double.compare(
                this.convertToBaseUnit(),
                other.convertToBaseUnit()) == 0;
    }

    /**
     * hashCode()
     */
    @Override
    public int hashCode() {

        return Objects.hash(
                convertToBaseUnit(),
                unit.getClass());
    }

    /**
     * Convert to target unit
     */
    public Quantity<U> convertTo(
            U targetUnit) {

        if (targetUnit == null) {

            throw new IllegalArgumentException(
                    "Target unit cannot be null");
        }

        double baseValue = this.convertToBaseUnit();

        double convertedValue = targetUnit.convertFromBaseUnit(
                baseValue);

        return new Quantity<>(
                convertedValue,
                targetUnit);
    }

    /**
     * Addition
     * Result in first operand's unit
     */
    public Quantity<U> add(
            Quantity<U> other) {

        if (other == null) {

            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        double totalBaseValue = this.convertToBaseUnit()
                + other.convertToBaseUnit();

        double result = this.unit.convertFromBaseUnit(
                totalBaseValue);

        return new Quantity<>(
                result,
                this.unit);
    }

    /**
     * Addition with explicit target unit
     */
    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        if (other == null
                || targetUnit == null) {

            throw new IllegalArgumentException(
                    "Quantity or target unit cannot be null");
        }

        double totalBaseValue = this.convertToBaseUnit()
                + other.convertToBaseUnit();

        double convertedValue = targetUnit.convertFromBaseUnit(
                totalBaseValue);

        return new Quantity<>(
                convertedValue,
                targetUnit);
    }

    /**
     * Subtraction
     * Result in first operand's unit
     */
    public Quantity<U> subtract(
            Quantity<U> other) {

        if (other == null) {

            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        double resultBaseValue = this.convertToBaseUnit()
                - other.convertToBaseUnit();

        double result = this.unit.convertFromBaseUnit(
                resultBaseValue);

        return new Quantity<>(
                result,
                this.unit);
    }

    /**
     * UC 12 -Subtraction with explicit target unit
     */
    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        if (other == null
                || targetUnit == null) {

            throw new IllegalArgumentException(
                    "Quantity or target unit cannot be null");
        }

        double resultBaseValue = this.convertToBaseUnit()
                - other.convertToBaseUnit();

        double convertedValue = targetUnit.convertFromBaseUnit(
                resultBaseValue);

        return new Quantity<>(
                convertedValue,
                targetUnit);
    }

    /**
     * Division
     * Returns dimensionless ratio
     */
    public double divide(
            Quantity<U> other) {

        if (other == null) {

            throw new IllegalArgumentException(
                    "Quantity cannot be null");
        }

        double divisor = other.convertToBaseUnit();

        if (Double.compare(
                divisor,
                0.0) == 0) {

            throw new ArithmeticException(
                    "Division by zero");
        }

        return this.convertToBaseUnit()
                / divisor;
    }

    @Override
    public String toString() {

        return String.format(
                "%.2f %s",
                value,
                unit.getUnitName());
    }

    public double getValue() {

        return value;
    }

    public U getUnit() {

        return unit;
    }
}