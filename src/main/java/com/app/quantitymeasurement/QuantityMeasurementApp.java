package com.app.quantitymeasurement;

public class QuantityMeasurementApp {

        public static void main(String[] args) {

                System.out.println(
                                "===== UC12  =====\n");

                demonstrateLengthOperations();

                demonstrateWeightOperations();

                demonstrateVolumeOperations();

                demonstrateSubtractionOperations();

                demonstrateDivisionOperations();
                demonstrateTemperatureOperations();

                demonstrateCrossCategorySafety();

                System.out.println(TemperatureUnit.CELSIUS.getClass());
                System.out.println(TemperatureUnit.FAHRENHEIT.getClass());
                System.out.println(TemperatureUnit.KELVIN.getClass());

                System.out.println(
                                TemperatureUnit.CELSIUS.convertToBaseUnit(0));

                System.out.println(
                                TemperatureUnit.FAHRENHEIT.convertToBaseUnit(32));

                System.out.println(
                                TemperatureUnit.KELVIN.convertToBaseUnit(273.15));
        }

        /**
         * Length Demonstration
         */
        private static void demonstrateLengthOperations() {

                System.out.println(
                                "----- Length Operations -----");

                Quantity<LengthUnit> length1 = new Quantity<>(
                                1.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> length2 = new Quantity<>(
                                12.0,
                                LengthUnit.INCHES);

                System.out.println(
                                "Length 1: " + length1);

                System.out.println(
                                "Length 2: " + length2);

                System.out.println(
                                "\nEquality Check:");

                System.out.println(
                                length1.equals(length2));

                System.out.println(
                                "\nAddition:");

                Quantity<LengthUnit> result = length1.add(length2);

                System.out.println(result);

                System.out.println(
                                "\nAddition in INCHES:");

                Quantity<LengthUnit> inchResult = length1.add(
                                length2,
                                LengthUnit.INCHES);

                System.out.println(inchResult);

                System.out.println(
                                "\nConvert FEET to YARDS:");

                System.out.println(
                                length1.convertTo(
                                                LengthUnit.YARDS));

                System.out.println();
        }

        /**
         * Weight Demonstration
         */
        private static void demonstrateWeightOperations() {

                System.out.println(
                                "----- Weight Operations -----");

                Quantity<WeightUnit> weight1 = new Quantity<>(
                                1.0,
                                WeightUnit.KILOGRAM);

                Quantity<WeightUnit> weight2 = new Quantity<>(
                                1000.0,
                                WeightUnit.GRAM);

                System.out.println(
                                "Weight 1: " + weight1);

                System.out.println(
                                "Weight 2: " + weight2);

                System.out.println(
                                "\nEquality Check:");

                System.out.println(
                                weight1.equals(weight2));

                System.out.println(
                                "\nAddition:");

                Quantity<WeightUnit> result = weight1.add(weight2);

                System.out.println(result);

                System.out.println(
                                "\nAddition in GRAM:");

                Quantity<WeightUnit> gramResult = weight1.add(
                                weight2,
                                WeightUnit.GRAM);

                System.out.println(gramResult);

                System.out.println(
                                "\nConvert KG to POUND:");

                System.out.println(
                                weight1.convertTo(
                                                WeightUnit.POUND));

                System.out.println();
        }

        /**
         * Volume Demonstration
         */
        private static void demonstrateVolumeOperations() {

                System.out.println(
                                "----- Volume Operations -----");

                Quantity<VolumeUnit> volume1 = new Quantity<>(
                                1.0,
                                VolumeUnit.LITRE);

                Quantity<VolumeUnit> volume2 = new Quantity<>(
                                1000.0,
                                VolumeUnit.MILLILITRE);

                Quantity<VolumeUnit> volume3 = new Quantity<>(
                                1.0,
                                VolumeUnit.GALLON);

                System.out.println(
                                "Volume 1: " + volume1);

                System.out.println(
                                "Volume 2: " + volume2);

                System.out.println(
                                "Volume 3: " + volume3);

                System.out.println(
                                "\nEquality Check:");

                System.out.println(
                                volume1.equals(volume2));

                System.out.println(
                                "\nAddition:");

                Quantity<VolumeUnit> result = volume1.add(volume2);

                System.out.println(result);

                System.out.println(
                                "\nAddition in MILLILITRE:");

                Quantity<VolumeUnit> mlResult = volume1.add(
                                volume2,
                                VolumeUnit.MILLILITRE);

                System.out.println(mlResult);

                System.out.println(
                                "\nConvert GALLON to LITRE:");

                System.out.println(
                                volume3.convertTo(
                                                VolumeUnit.LITRE));

                System.out.println();
        }

        /**
         * UC-12 Subtraction Demonstration
         */
        private static void demonstrateSubtractionOperations() {

                System.out.println(
                                "----- Subtraction Operations -----");

                Quantity<LengthUnit> length1 = new Quantity<>(10.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> length2 = new Quantity<>(6.0,
                                LengthUnit.INCHES);

                Quantity<LengthUnit> result = length1.subtract(length2);

                System.out.println(
                                "10 FEET - 6 INCHES = "
                                                + result);

                Quantity<LengthUnit> inchResult = length1.subtract(
                                length2,
                                LengthUnit.INCHES);

                System.out.println(
                                "10 FEET - 6 INCHES (INCHES) = "
                                                + inchResult);

                System.out.println();
        }

        /**
         * Division Demonstration
         */
        private static void demonstrateDivisionOperations() {

                System.out.println(
                                "----- Division Operations -----");

                Quantity<LengthUnit> length1 = new Quantity<>(24.0,
                                LengthUnit.INCHES);

                Quantity<LengthUnit> length2 = new Quantity<>(2.0,
                                LengthUnit.FEET);

                double ratio = length1.divide(length2);

                System.out.println(
                                "24 INCHES / 2 FEET = "
                                                + ratio);

                Quantity<WeightUnit> weight1 = new Quantity<>(10.0,
                                WeightUnit.KILOGRAM);

                Quantity<WeightUnit> weight2 = new Quantity<>(5.0,
                                WeightUnit.KILOGRAM);

                System.out.println(
                                "10 KG / 5 KG = "
                                                + weight1.divide(weight2));

                System.out.println();
        }

        /**
         * UC-14Temperature Demonstration
         */
        private static void demonstrateTemperatureOperations() {

                System.out.println(
                                "----- Temperature Operations -----");

                Quantity<TemperatureUnit> celsius = new Quantity<>(
                                0.0,
                                TemperatureUnit.CELSIUS);

                Quantity<TemperatureUnit> fahrenheit = new Quantity<>(
                                32.0,
                                TemperatureUnit.FAHRENHEIT);

                Quantity<TemperatureUnit> kelvin = new Quantity<>(
                                273.15,
                                TemperatureUnit.KELVIN);

                System.out.println(
                                "0°C equals 32°F ?");

                System.out.println(
                                celsius.equals(fahrenheit));

                System.out.println(
                                "0°C equals 273.15K ?");

                System.out.println(
                                celsius.equals(kelvin));

                System.out.println(
                                "\nConvert 100°C to Fahrenheit:");

                Quantity<TemperatureUnit> boilingPoint = new Quantity<>(
                                100.0,
                                TemperatureUnit.CELSIUS);

                System.out.println(
                                boilingPoint.convertTo(
                                                TemperatureUnit.FAHRENHEIT));

                System.out.println(
                                "\nUnsupported Operation Demo:");

                try {

                        celsius.add(
                                        new Quantity<>(
                                                        10.0,
                                                        TemperatureUnit.CELSIUS));

                } catch (UnsupportedOperationException ex) {

                        System.out.println(
                                        ex.getMessage());
                }

                System.out.println();
        }

        /**
         * Cross-category safety
         */
        private static void demonstrateCrossCategorySafety() {

                System.out.println(
                                "----- Cross Category Safety -----");

                Quantity<LengthUnit> length = new Quantity<>(
                                1.0,
                                LengthUnit.FEET);

                Quantity<WeightUnit> weight = new Quantity<>(
                                1.0,
                                WeightUnit.KILOGRAM);

                System.out.println(
                                "Length equals Weight?");

                System.out.println(
                                length.equals(weight));
        }
}