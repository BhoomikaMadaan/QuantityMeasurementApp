package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.IMeasurable;
import com.app.quantitymeasurement.Quantity;
import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(
            IQuantityMeasurementService service) {

        this.service = service;
    }

    /**
     * Compare two quantities
     */
    public <U extends IMeasurable> boolean performComparison(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2) {

        return service.compare(
                quantity1,
                quantity2);
    }

    /**
     * Convert quantity
     */
    public <U extends IMeasurable> Quantity<U> performConversion(
            QuantityDTO<U> quantity,
            U targetUnit) {

        return service.convert(
                quantity,
                targetUnit);
    }

    /**
     * Add quantities
     */
    public <U extends IMeasurable> Quantity<U> performAddition(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2) {

        return service.add(
                quantity1,
                quantity2);
    }
    
    public <U extends IMeasurable> Quantity<U> performAddition(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit) {

        return service.add(
                quantity1,
                quantity2,
                targetUnit);
    }

    /**
     * Subtract quantities
     */
    public <U extends IMeasurable> Quantity<U> performSubtraction(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2) {

        return service.subtract(
                quantity1,
                quantity2);
    }
    
    public <U extends IMeasurable> Quantity<U> performSubtraction(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit) {

        return service.subtract(
                quantity1,
                quantity2,
                targetUnit);
    }

    /**
     * Divide quantities
     */
    public <U extends IMeasurable> double performDivision(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2) {

        return service.divide(
                quantity1,
                quantity2);
    }
}