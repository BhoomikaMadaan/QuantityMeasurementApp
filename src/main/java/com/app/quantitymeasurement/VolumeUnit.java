package com.app.quantitymeasurement;

public enum VolumeUnit
        implements IMeasurable {

    LITRE(1.0),

    MILLILITRE(0.001),

    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {

        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {

        return conversionFactor;
    }

    /**
     * Convert current value
     * to base unit (LITRE)
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
    
    @Override
    public String getMeasurementType() {

        return this.getClass().getSimpleName();
    }
}