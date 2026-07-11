package com.app.quantitymeasurement.service;



import com.app.quantitymeasurement.IMeasurable;
import com.app.quantitymeasurement.Quantity;
import com.app.quantitymeasurement.model.QuantityDTO;
import java.util.List;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
//import com.app.quantitymeasurement.model.QuantityMeasurementEntity;


public interface IQuantityMeasurementService {

    <U extends IMeasurable> boolean compare(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2);

    <U extends IMeasurable> Quantity<U> convert(
            QuantityDTO<U> quantity,
            U targetUnit);

    <U extends IMeasurable> Quantity<U> add(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2);
    <U extends IMeasurable> Quantity<U> add(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit);

    <U extends IMeasurable> Quantity<U> subtract(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2);
    <U extends IMeasurable> Quantity<U> subtract(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit);

    <U extends IMeasurable> double divide(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2);
    
    List<QuantityMeasurementEntity>
    getHistoryByOperation(String operation);

    List<QuantityMeasurementEntity>
    getHistoryByMeasurementType(
            String type);

    Long getOperationCount(
            String operation);

    List<QuantityMeasurementEntity>
    getErrorHistory();
}