package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.IMeasurable;
import com.app.quantitymeasurement.Quantity;
import com.app.quantitymeasurement.repository.QuantityMeasurementRepository;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.model.QuantityDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {
	
	@Autowired
	private QuantityMeasurementRepository repository;
//	private final IQuantityMeasurementRepository repository;
//	public QuantityMeasurementServiceImpl(
//	        IQuantityMeasurementRepository repository) {
//
//	    this.repository = repository;
//	}
//	
	private enum ArithmeticOperation {

	    ADD {
	        @Override
	        double apply(double left, double right) {
	            return left + right;
	        }
	    },

	    SUBTRACT {
	        @Override
	        double apply(double left, double right) {
	            return left - right;
	        }
	    },

	    DIVIDE {
	        @Override
	        double apply(double left, double right) {

	            if (Double.compare(right, 0.0) == 0) {
	                throw new ArithmeticException("Division by zero");
	            }

	            return left / right;
	        }
	    };

	    abstract double apply(double left, double right);
	}
	@Override
	public List<QuantityMeasurementEntity>
	getHistoryByOperation(
	        String operation){

	    return repository
	            .findByOperation(operation);
	}

	@Override
	public List<QuantityMeasurementEntity>
	getHistoryByMeasurementType(
	        String type){

	    return repository
	            .findByThisMeasurementType(type);
	}

	@Override
	public Long getOperationCount(
	        String operation){

	    return repository
	            .countByOperationAndIsErrorFalse(
	                    operation);
	}

	@Override
	public List<QuantityMeasurementEntity>
	getErrorHistory(){

	    return repository
	            .findByIsErrorTrue();
	}
 	
	private <U extends IMeasurable> boolean compare(
	        Quantity<U> quantity1,
	        Quantity<U> quantity2) {

	    return quantity1.equals(quantity2);
	}

	private <U extends IMeasurable> Quantity<U> convertTo(
	        Quantity<U> quantity,
	        U targetUnit) {

	    return quantity.convertTo(targetUnit);
	}
	
	private <U extends IMeasurable> void validateArithmeticOperands(
	        Quantity<U> quantity1,
	        Quantity<U> quantity2) {

	    if (quantity1 == null || quantity2 == null) {
	        throw new IllegalArgumentException(
	                "Quantity cannot be null");
	    }

	    Class<?> type1 =
	            quantity1.getUnit() instanceof Enum<?>
	                    ? ((Enum<?>) quantity1.getUnit()).getDeclaringClass()
	                    : quantity1.getUnit().getClass();

	    Class<?> type2 =
	            quantity2.getUnit() instanceof Enum<?>
	                    ? ((Enum<?>) quantity2.getUnit()).getDeclaringClass()
	                    : quantity2.getUnit().getClass();

	    if (type1 != type2) {

	        throw new IllegalArgumentException(
	                "Incompatible measurement categories");
	    }

	    if (!quantity1.getUnit().supportsArithmetic()) {

	        quantity1.getUnit()
	                .validateOperationSupport("ADD");
	    }
	}
	
	private <U extends IMeasurable> double performArithmetic(
	        Quantity<U> quantity1,
	        Quantity<U> quantity2,
	        ArithmeticOperation operation) {

	    validateArithmeticOperands(quantity1, quantity2);

	    double left =
	            quantity1.getUnit().convertToBaseUnit(
	                    quantity1.getValue());

	    double right =
	            quantity2.getUnit().convertToBaseUnit(
	                    quantity2.getValue());

	    return operation.apply(left, right);
	}
	
	@Override
	public <U extends IMeasurable> boolean compare(
	        QuantityDTO<U> quantity1,
	        QuantityDTO<U> quantity2) {

	    Quantity<U> q1 = new Quantity<>(
	            quantity1.getValue(),
	            quantity1.getUnit());

	    Quantity<U> q2 = new Quantity<>(
	            quantity2.getValue(),
	            quantity2.getUnit());

	    boolean result = compare(q1, q2);

	    QuantityMeasurementEntity entity =
	            new QuantityMeasurementEntity(
	                    q1,
	                    q2,
	                    "COMPARE",
	                    String.valueOf(result));

	    repository.save(entity);

	    return result;
	}

	@Override
	public <U extends IMeasurable> Quantity<U> convert(
	        QuantityDTO<U> quantity,
	        U targetUnit) {

	    Quantity<U> q = new Quantity<>(
	            quantity.getValue(),
	            quantity.getUnit());

	    Quantity<U> result = convertTo(q, targetUnit);

	    QuantityMeasurementEntity entity =
	            new QuantityMeasurementEntity(
	                    q,
	                    null,
	                    "CONVERT",
	                    result);

	    repository.save(entity);

	    return result;
	}

	@Override
	public <U extends IMeasurable> Quantity<U> add(
	        QuantityDTO<U> quantity1,
	        QuantityDTO<U> quantity2) {

	    Quantity<U> q1 = new Quantity<>(
	            quantity1.getValue(),
	            quantity1.getUnit());

	    Quantity<U> q2 = new Quantity<>(
	            quantity2.getValue(),
	            quantity2.getUnit());

	    double resultBase =
	            performArithmetic(
	                    q1,
	                    q2,
	                    ArithmeticOperation.ADD);

	    double converted =
	            q1.getUnit().convertFromBaseUnit(resultBase);

	    Quantity<U> result =
	            new Quantity<>(
	                    converted,
	                    q1.getUnit());

	    QuantityMeasurementEntity entity =
	            new QuantityMeasurementEntity(
	                    q1,
	                    q2,
	                    "ADD",
	                    result);

	    repository.save(entity);

	    return result;
	}

	
	@Override
	public <U extends IMeasurable> Quantity<U> add(
	        QuantityDTO<U> quantity1,
	        QuantityDTO<U> quantity2,
	        U targetUnit) {

	    Quantity<U> q1 =
	            new Quantity<>(
	                    quantity1.getValue(),
	                    quantity1.getUnit());

	    Quantity<U> q2 =
	            new Quantity<>(
	                    quantity2.getValue(),
	                    quantity2.getUnit());

	    Quantity<U> result =
	            q1.add(
	                    q2,
	                    targetUnit);

	    QuantityMeasurementEntity entity =
	            new QuantityMeasurementEntity(
	                    q1,
	                    q2,
	                    "ADD",
	                    result);

	    repository.save(entity);

	    return result;
	}
	@Override
	public <U extends IMeasurable> Quantity<U> subtract(
	        QuantityDTO<U> quantity1,
	        QuantityDTO<U> quantity2) {

	    Quantity<U> q1 = new Quantity<>(
	            quantity1.getValue(),
	            quantity1.getUnit());

	    Quantity<U> q2 = new Quantity<>(
	            quantity2.getValue(),
	            quantity2.getUnit());

	    double resultBase =
	            performArithmetic(
	                    q1,
	                    q2,
	                    ArithmeticOperation.SUBTRACT);

	    double converted =
	            q1.getUnit().convertFromBaseUnit(resultBase);

	    Quantity<U> result =
	            new Quantity<>(
	                    converted,
	                    q1.getUnit());

	    QuantityMeasurementEntity entity =
	            new QuantityMeasurementEntity(
	                    q1,
	                    q2,
	                    "SUBTRACT",
	                    result);

	    repository.save(entity);

	    return result;
	}

	
	@Override
	public <U extends IMeasurable> Quantity<U> subtract(
	        QuantityDTO<U> quantity1,
	        QuantityDTO<U> quantity2,
	        U targetUnit) {

	    Quantity<U> q1 =
	            new Quantity<>(
	                    quantity1.getValue(),
	                    quantity1.getUnit());

	    Quantity<U> q2 =
	            new Quantity<>(
	                    quantity2.getValue(),
	                    quantity2.getUnit());

	    Quantity<U> result =
	            q1.subtract(
	                    q2,
	                    targetUnit);

	    QuantityMeasurementEntity entity =
	            new QuantityMeasurementEntity(
	                    q1,
	                    q2,
	                    "SUBTRACT",
	                    result);

	    repository.save(entity);

	    return result;
	}
	@Override
	public <U extends IMeasurable> double divide(
	        QuantityDTO<U> quantity1,
	        QuantityDTO<U> quantity2) {

	    Quantity<U> q1 = new Quantity<>(
	            quantity1.getValue(),
	            quantity1.getUnit());

	    Quantity<U> q2 = new Quantity<>(
	            quantity2.getValue(),
	            quantity2.getUnit());

	    double result =
	            performArithmetic(
	                    q1,
	                    q2,
	                    ArithmeticOperation.DIVIDE);

	    Quantity<U> resultQuantity =
	            new Quantity<>(
	                    result,
	                    q1.getUnit());

	    QuantityMeasurementEntity entity =
	            new QuantityMeasurementEntity(
	                    q1,
	                    q2,
	                    "DIVIDE",
	                    resultQuantity);

	    repository.save(entity);

	    return result;
	    
	    
	}
}