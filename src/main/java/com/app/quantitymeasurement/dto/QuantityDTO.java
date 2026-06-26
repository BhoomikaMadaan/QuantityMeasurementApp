package com.app.quantitymeasurement.dto;

import com.app.quantitymeasurement.IMeasurable;

public class QuantityDTO<U extends IMeasurable> {

    private double value;

    private U unit;

    public QuantityDTO() {
    }

    public QuantityDTO(
            double value,
            U unit) {

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {

        return value;
    }

    public void setValue(
            double value) {

        this.value = value;
    }

    public U getUnit() {

        return unit;
    }

    public void setUnit(
            U unit) {

        this.unit = unit;
    }

    @Override
    public String toString() {

        return String.format(
                "%.2f %s",
                value,
                unit.getUnitName());
    }
}