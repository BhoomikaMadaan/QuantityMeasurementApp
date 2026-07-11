package com.app.quantitymeasurement.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.quantitymeasurement.IMeasurable;
import com.app.quantitymeasurement.Quantity;
import com.app.quantitymeasurement.model.QuantityDTO;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import java.util.List;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.model.QuantityRequestDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/quantity")
public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(
            IQuantityMeasurementService service) {

        this.service = service;
    }
    
    @GetMapping(
            "/history/operation/{operation}")
    public List<QuantityMeasurementEntity>
    getHistory(
            @PathVariable String operation){

        return service
                .getHistoryByOperation(
                        operation);
    }
    @GetMapping(
            "/history/type/{type}")
    public List<QuantityMeasurementEntity>
    getByType(
            @PathVariable String type){

        return service
                .getHistoryByMeasurementType(
                        type);
    }
    
    @GetMapping(
            "/count/{operation}")
    public Long count(
            @PathVariable String operation){

        return service
                .getOperationCount(
                        operation);
    }
    
    @GetMapping(
            "/history/errored")
    public List<
            QuantityMeasurementEntity>
    getErrors(){

        return service
                .getErrorHistory();
    }
    
    @PostMapping("/compare")
    @SuppressWarnings("unchecked")
    public boolean compare(
         @Valid   @RequestBody QuantityRequestDTO request){

    	return service.compare(
    	        (QuantityDTO) request.getQuantity1(),
    	        (QuantityDTO) request.getQuantity2());
    }
    
    @PostMapping("/add")
    @SuppressWarnings("unchecked")
    public Quantity<?> add(
    		@Valid    @RequestBody QuantityRequestDTO request){

        return service.add(
        		(QuantityDTO) request.getQuantity1(),
    	        (QuantityDTO) request.getQuantity2());
    }
    
    @PostMapping("/subtract")
    @SuppressWarnings("unchecked")
    public Quantity<?> subtract(
    		@Valid    @RequestBody QuantityRequestDTO request){

        return service.subtract(
        		(QuantityDTO) request.getQuantity1(),
    	        (QuantityDTO) request.getQuantity2());
    }
    
    @PostMapping("/divide")
    @SuppressWarnings("unchecked")
    public double divide(
    		@Valid     @RequestBody QuantityRequestDTO request){

        return service.divide(
        		(QuantityDTO) request.getQuantity1(),
    	        (QuantityDTO) request.getQuantity2());
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