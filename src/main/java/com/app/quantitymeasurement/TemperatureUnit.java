package com.app.quantitymeasurement;

public enum TemperatureUnit
        implements IMeasurable {

    CELSIUS {

        @Override
        public double convertToBaseUnit(
                double value) {

            return value;
        }

        @Override
        public double convertFromBaseUnit(
                double baseValue) {

            return baseValue;
        }
    },

    FAHRENHEIT {

        @Override
        public double convertToBaseUnit(
                double value) {

            return (value - 32) * 5.0 / 9.0;
        }

        @Override
        public double convertFromBaseUnit(
                double baseValue) {

            return (baseValue * 9.0 / 5.0) + 32;
        }
    },

    KELVIN {

        @Override
        public double convertToBaseUnit(
                double value) {

            return value - 273.15;
        }

        @Override
        public double convertFromBaseUnit(
                double baseValue) {

            return baseValue + 273.15;
        }
    };

    private final SupportsArithmetic supportsArithmetic = () -> false;

    @Override
    public boolean supportsArithmetic() {

        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(
            String operation) {

        throw new UnsupportedOperationException(
                "Temperature does not support "
                        + operation
                        + " operation");
    }

    @Override
    public double getConversionFactor() {

        return 1.0;
    }

    @Override
    public String getUnitName() {

        return this.name();
    }
    @Override
    public String getMeasurementType() {

        return this.getClass().getSimpleName();
    }
}