package com.app.quantitymeasurement.entity;

import java.io.Serializable;

import com.app.quantitymeasurement.IMeasurable;
import com.app.quantitymeasurement.Quantity;

public class QuantityMeasurementEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public double thisValue;
    public String thisUnit;
    public String thisMeasurementType;

    public double otherValue;
    public String otherUnit;
    public String otherMeasurementType;

    // "COMPARE", "CONVERT", "ADD", "SUBTRACT", "DIVIDE"
    public String operation;

    public double resultValue;
    public String resultUnit;
    public String resultMeasurementType;

    // Comparison result
    public String result;

    // Error handling
    public boolean isError;
    public String errorMessage;

    /**
     * Default constructor
     */
    public QuantityMeasurementEntity() {
    }

    /**
     * Constructor for comparison operations
     */
    public QuantityMeasurementEntity(
            Quantity<? extends IMeasurable> thisQuantity,
            Quantity<? extends IMeasurable> otherQuantity,
            String operation,
            String result) {

        this.thisValue = thisQuantity.getValue();
        this.thisUnit = thisQuantity.getUnit().getUnitName();
        this.thisMeasurementType = thisQuantity.getUnit().getMeasurementType();

        this.otherValue = otherQuantity.getValue();
        this.otherUnit = otherQuantity.getUnit().getUnitName();
        this.otherMeasurementType = otherQuantity.getUnit().getMeasurementType();

        this.operation = operation;
        this.result = result;
    }

    /**
     * Constructor for arithmetic/conversion operations
     */
    public QuantityMeasurementEntity(
            Quantity<? extends IMeasurable> thisQuantity,
            Quantity<? extends IMeasurable> otherQuantity,
            String operation,
            Quantity<? extends IMeasurable> resultQuantity) {

        this.thisValue = thisQuantity.getValue();
        this.thisUnit = thisQuantity.getUnit().getUnitName();
        this.thisMeasurementType = thisQuantity.getUnit().getMeasurementType();

        if (otherQuantity != null) {

            this.otherValue = otherQuantity.getValue();
            this.otherUnit = otherQuantity.getUnit().getUnitName();
            this.otherMeasurementType = otherQuantity.getUnit().getMeasurementType();
        }

        this.operation = operation;

        this.resultValue = resultQuantity.getValue();
        this.resultUnit = resultQuantity.getUnit().getUnitName();
        this.resultMeasurementType = resultQuantity.getUnit().getMeasurementType();
    }

    /**
     * Constructor for error cases
     */
    public QuantityMeasurementEntity(
            Quantity<? extends IMeasurable> thisQuantity,
            Quantity<? extends IMeasurable> otherQuantity,
            String operation,
            String errorMessage,
            boolean isError) {

        this.thisValue = thisQuantity.getValue();
        this.thisUnit = thisQuantity.getUnit().getUnitName();
        this.thisMeasurementType = thisQuantity.getUnit().getMeasurementType();

        if (otherQuantity != null) {

            this.otherValue = otherQuantity.getValue();
            this.otherUnit = otherQuantity.getUnit().getUnitName();
            this.otherMeasurementType = otherQuantity.getUnit().getMeasurementType();
        }

        this.operation = operation;

        this.errorMessage = errorMessage;
        this.isError = isError;
    }

    @Override
    public String toString() {

        return "Operation : "
                + operation
                + ", Result : "
                + (isError ? errorMessage : result);
    }
}