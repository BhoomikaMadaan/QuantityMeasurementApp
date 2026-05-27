package com.app.quantitymeasurement;

public enum LengthUnit
        implements IMeasurable {

    FEET(1.0),

    INCHES(1.0 / 12),

    YARDS(3.0),

    CENTIMETERS(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {

        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {

        return conversionFactor;
    }

    /**
     * Convert current value
     * to base unit (FEET)
     */
    @Override
    public double convertToBaseUnit(
            double value) {

        return value * conversionFactor;
    }

    /**
     * Convert base unit value
     * to target unit
     */
    @Override
    public double convertFromBaseUnit(
            double baseValue) {

        return baseValue / conversionFactor;
    }

    @Override
    public String getUnitName() {

        return this.name();
    }
}