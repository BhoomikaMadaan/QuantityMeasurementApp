package com.app.quantitymeasurement;

public interface IMeasurable {

    double getConversionFactor();

    double convertToBaseUnit(
            double value);

    double convertFromBaseUnit(
            double baseValue);

    String getUnitName();

    /**
     * By default every
     * measurable unit supports
     * arithmetic operations
     */
    default boolean supportsArithmetic() {

        return true;
    }

    /**
     * Validate whether
     * arithmetic operation
     * is supported
     */
    default void validateOperationSupport(
            String operation) {

        // Default: allow all operations
    }
}