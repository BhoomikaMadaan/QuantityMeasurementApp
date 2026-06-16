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

                demonstrateCrossCategorySafety();
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