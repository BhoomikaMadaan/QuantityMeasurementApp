package com.app.quantitymeasurement.model;

import com.app.quantitymeasurement.IMeasurable;

import jakarta.validation.constraints.NotNull;

public class QuantityDTO<U extends IMeasurable> {

	@NotNull
	private Double value;

	@NotNull
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