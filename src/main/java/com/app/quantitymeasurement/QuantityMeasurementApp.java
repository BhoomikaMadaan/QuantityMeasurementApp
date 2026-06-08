package com.app.quantitymeasurement;

public class QuantityMeasurementApp {

        public static void main(String[] args) {

                System.out.println(
                                "===== UC10 Generic Quantity Framework =====\n");

                demonstrateLengthOperations();

                demonstrateWeightOperations();
                demonstrateVolumeOperations();

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