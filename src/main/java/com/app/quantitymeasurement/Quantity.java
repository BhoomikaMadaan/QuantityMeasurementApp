package com.app.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

        // UC-13 REFACTOR: Introduced ArithmeticOperation enum to encapsulate arithmetic
        // operations and their logic.

        private enum ArithmeticOperation {

                ADD {
                        @Override
                        double compute(
                                        double left,
                                        double right) {

                                return left + right;
                        }
                },

                SUBTRACT {
                        @Override
                        double compute(
                                        double left,
                                        double right) {

                                return left - right;
                        }
                },

                DIVIDE {
                        @Override
                        double compute(
                                        double left,
                                        double right) {

                                if (Double.compare(
                                                right,
                                                0.0) == 0) {

                                        throw new ArithmeticException(
                                                        "Division by zero");
                                }

                                return left / right;
                        }
                };

                abstract double compute(
                                double left,
                                double right);
        }

        private final double value;

        private final U unit;

        /**
         * Constructor
         */
        public Quantity(
                        double value,
                        U unit) {

                if (unit == null) {

                        throw new IllegalArgumentException(
                                        "Unit cannot be null");
                }

                if (Double.isNaN(value)
                                || Double.isInfinite(value)) {

                        throw new IllegalArgumentException(
                                        "Invalid quantity value");
                }

                this.value = value;
                this.unit = unit;
        }

        /**
         * Convert current quantity
         * to base unit
         */
        private double convertToBaseUnit() {

                return unit.convertToBaseUnit(value);
        }

        // UC13-Validate operands for arithmetic operations

        private void validateArithmeticOperands(
                        Quantity<U> other,
                        U targetUnit,
                        boolean targetUnitRequired) {

                if (other == null) {

                        throw new IllegalArgumentException(
                                        "Quantity cannot be null");
                }

                if (this.unit.getClass() != other.unit.getClass()) {

                        throw new IllegalArgumentException(
                                        "Incompatible measurement categories");
                }

                if (Double.isNaN(this.value)
                                || Double.isInfinite(this.value)
                                || Double.isNaN(other.value)
                                || Double.isInfinite(other.value)) {

                        throw new IllegalArgumentException(
                                        "Invalid quantity value");
                }

                if (targetUnitRequired
                                && targetUnit == null) {

                        throw new IllegalArgumentException(
                                        "Target unit cannot be null");
                }
        }

        // UC13-Refactored arithmetic operations to use performBaseArithmetic method
        private double performBaseArithmetic(
                        Quantity<U> other,
                        ArithmeticOperation operation) {

                double left = this.convertToBaseUnit();

                double right = other.convertToBaseUnit();

                return operation.compute(
                                left,
                                right);
        }

        /**
         * Equality check
         */
        @Override
        public boolean equals(Object obj) {

                if (this == obj)
                        return true;

                if (obj == null)
                        return false;

                if (getClass() != obj.getClass())
                        return false;

                Quantity<?> other = (Quantity<?>) obj;

                if (((Enum<?>) this.unit).getDeclaringClass() != ((Enum<?>) other.unit).getDeclaringClass()) {

                        return false;
                }

                return Math.abs(
                                this.convertToBaseUnit()
                                                - other.convertToBaseUnit()) < 0.0001;
        }

        /**
         * hashCode()
         */
        @Override
        public int hashCode() {

                return Objects.hash(
                                convertToBaseUnit(),
                                ((Enum<?>) unit).getDeclaringClass());
        }

        /**
         * Convert to target unit
         */
        public Quantity<U> convertTo(
                        U targetUnit) {

                if (targetUnit == null) {

                        throw new IllegalArgumentException(
                                        "Target unit cannot be null");
                }

                double baseValue = this.convertToBaseUnit();

                double convertedValue = targetUnit.convertFromBaseUnit(
                                baseValue);

                return new Quantity<>(
                                convertedValue,
                                targetUnit);
        }

        /**
         * UC-13 refactor add method to use performBaseArithmetic for addition
         */
        public Quantity<U> add(
                        Quantity<U> other) {

                validateArithmeticOperands(
                                other,
                                null,
                                false);
                /**
                 * UC-14
                 */
                this.unit.validateOperationSupport(
                                "ADD");

                double resultBaseValue = performBaseArithmetic(
                                other,
                                ArithmeticOperation.ADD);

                double result = this.unit.convertFromBaseUnit(
                                resultBaseValue);

                return new Quantity<>(
                                result,
                                this.unit);
        }

        /**
         * UC13 -refactor add method to use performBaseArithmetic for addition with
         * explicit target unit
         */
        public Quantity<U> add(
                        Quantity<U> other,
                        U targetUnit) {

                validateArithmeticOperands(
                                other,
                                targetUnit,
                                true);

                this.unit.validateOperationSupport(
                                "ADD");

                double resultBaseValue = performBaseArithmetic(
                                other,
                                ArithmeticOperation.ADD);

                double convertedValue = targetUnit.convertFromBaseUnit(
                                resultBaseValue);

                return new Quantity<>(
                                convertedValue,
                                targetUnit);
        }

        /**
         * UC13-Refactor subtract method to use performBaseArithmetic for subtraction
         */
        public Quantity<U> subtract(
                        Quantity<U> other) {

                validateArithmeticOperands(
                                other,
                                null,
                                false);
                this.unit.validateOperationSupport(
                                "SUBTRACT");

                double resultBaseValue = performBaseArithmetic(
                                other,
                                ArithmeticOperation.SUBTRACT);

                double result = this.unit.convertFromBaseUnit(
                                resultBaseValue);

                return new Quantity<>(
                                result,
                                this.unit);
        }

        /**
         * UC 13 -refactor subtract method to use performBaseArithmetic for subtraction
         * with
         */
        public Quantity<U> subtract(
                        Quantity<U> other,
                        U targetUnit) {

                validateArithmeticOperands(
                                other,
                                targetUnit,
                                true);

                this.unit.validateOperationSupport(
                                "SUBTRACT");

                double resultBaseValue = performBaseArithmetic(
                                other,
                                ArithmeticOperation.SUBTRACT);

                double convertedValue = targetUnit.convertFromBaseUnit(
                                resultBaseValue);

                return new Quantity<>(
                                convertedValue,
                                targetUnit);
        }

        /**
         * UC13 - Refactor divide method to use performBaseArithmetic for division
         */
        public double divide(
                        Quantity<U> other) {

                validateArithmeticOperands(
                                other,
                                null,
                                false);

                this.unit.validateOperationSupport(
                                "DIVIDE");

                return performBaseArithmetic(
                                other,
                                ArithmeticOperation.DIVIDE);
        }

        @Override
        public String toString() {

                return String.format(
                                "%.2f %s",
                                value,
                                unit.getUnitName());
        }

        public double getValue() {

                return value;
        }

        public U getUnit() {

                return unit;
        }
}