package com.app.quantitymeasurement.model;

import com.app.quantitymeasurement.IMeasurable;

public class QuantityDTO<U extends IMeasurable> {

    private Double value;
    private U unit;

    public QuantityDTO() {
    }

    public QuantityDTO(
            Double value,
            U unit) {

        this.value = value;
        this.unit = unit;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(
            Double value) {

        this.value = value;
    }

    public U getUnit() {
        return unit;
    }

    public void setUnit(
            U unit) {

        this.unit = unit;
    }
}