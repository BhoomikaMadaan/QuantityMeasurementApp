//package com.app.quantitymeasurement;
//
//public interface IMeasurable {
//
//    double getConversionFactor();
//
//    double convertToBaseUnit(
//            double value);
//
//    double convertFromBaseUnit(
//            double baseValue);
//
//    String getUnitName();
//
//    /**
//     * By default every
//     * measurable unit supports
//     * arithmetic operations
//     */
//    default boolean supportsArithmetic() {
//
//        return true;
//    }
//
//    /**
//     * Validate whether
//     * arithmetic operation
//     * is supported
//     */
//    default void validateOperationSupport(
//            String operation) {
//
//        // Default: allow all operations
//    }
//}

package com.app.quantitymeasurement;

public interface IMeasurable {

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();

    /**
     * Returns the measurement type.
     * Example: LengthUnit, WeightUnit
     */
    default String getMeasurementType() {

        if (this instanceof Enum<?>) {

            return ((Enum<?>) this)
                    .getDeclaringClass()
                    .getSimpleName();
        }

        return this.getClass()
                .getSimpleName();
    }

    /**
     * Returns the corresponding unit instance
     * for the given unit name.
     */
    static IMeasurable getUnitInstance(
            String unitName) {

        for (LengthUnit unit : LengthUnit.values()) {

            if (unit.getUnitName().equalsIgnoreCase(unitName)) {

                return unit;
            }
        }

        for (WeightUnit unit : WeightUnit.values()) {

            if (unit.getUnitName().equalsIgnoreCase(unitName)) {

                return unit;
            }
        }

        for (VolumeUnit unit : VolumeUnit.values()) {

            if (unit.getUnitName().equalsIgnoreCase(unitName)) {

                return unit;
            }
        }

        for (TemperatureUnit unit : TemperatureUnit.values()) {

            if (unit.getUnitName().equalsIgnoreCase(unitName)) {

                return unit;
            }
        }

        throw new IllegalArgumentException(
                "Invalid measurement unit : " + unitName);
    }

    /**
     * UC14
     */
    default boolean supportsArithmetic() {

        return true;
    }

    /**
     * UC14
     */
    default void validateOperationSupport(
            String operation) {
    }
}