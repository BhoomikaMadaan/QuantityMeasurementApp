package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.IMeasurable;
import com.app.quantitymeasurement.Quantity;
import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {
	
	private final IQuantityMeasurementRepository repository;
	public QuantityMeasurementServiceImpl(
	        IQuantityMeasurementRepository repository) {

	    this.repository = repository;
	}
	
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

	    return compare(q1, q2);
	}

	@Override
	public <U extends IMeasurable> Quantity<U> convert(
	        QuantityDTO<U> quantity,
	        U targetUnit) {

	    Quantity<U> q = new Quantity<>(
	            quantity.getValue(),
	            quantity.getUnit());

	    return convertTo(q, targetUnit);
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

	    return new Quantity<>(
	            converted,
	            q1.getUnit());
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

	    return q1.add(
	            q2,
	            targetUnit);
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

	    return new Quantity<>(
	            converted,
	            q1.getUnit());
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

	    return q1.subtract(
	            q2,
	            targetUnit);
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

	    return performArithmetic(
	            q1,
	            q2,
	            ArithmeticOperation.DIVIDE);
	}
}