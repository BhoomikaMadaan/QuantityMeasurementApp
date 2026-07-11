package com.app.quantitymeasurement.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.app.quantitymeasurement.IMeasurable;
import com.app.quantitymeasurement.Quantity;

@Entity
@Table(name="quantity_measurement_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityMeasurementEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
	    return id;
	}

    private static final long serialVersionUID = 1L;

    private double thisValue;
    private String thisUnit;
    private String thisMeasurementType;

    private double otherValue;
    private String otherUnit;
    private String otherMeasurementType;

    // "COMPARE", "CONVERT", "ADD", "SUBTRACT", "DIVIDE"
    private String operation;

    private double resultValue;
    private String resultUnit;
    private String resultMeasurementType;

    // Comparison result
    private String result;

    // Error handling
    private boolean isError;
    private String errorMessage;

//    /**
//     * Default constructor
//     */
//    public QuantityMeasurementEntity() {
//    }

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
    
    public double getThisValue() {
        return thisValue;
    }

    public String getThisUnit() {
        return thisUnit;
    }

    public String getThisMeasurementType() {
        return thisMeasurementType;
    }

    public double getThatValue() {
        return otherValue;
    }

    public String getThatUnit() {
        return otherUnit;
    }

    public String getThatMeasurementType() {
        return otherMeasurementType;
    }

    public String getOperation() {
        return operation;
    }

    public double getResultValue() {
        return resultValue;
    }

    public String getResultUnit() {
        return resultUnit;
    }

    public String getResultMeasurementType() {
        return resultMeasurementType;
    }

    public String getResultString() {
        return result;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {

        return "Operation : "
                + operation
                + ", Result : "
                + (isError ? errorMessage : result);
    }
}