package com.app.quantitymeasurement;

public class QuantityMeasurementApp {

        /**
         * UC5 - Demonstrate Length Conversion
         */
        public static Length demonstrateLengthConversion(
                        Length length,
                        LengthUnit targetUnit) {

                return length.convertTo(targetUnit);
        }

        /**
         * UC6 - Addition using Length objects
         */
        public static Length demonstrateLengthAddition(
                        Length length1,
                        Length length2) {

                return length1.add(length2);
        }

        /**
         * UC6 - Overloaded Addition Method
         */
        public static Length demonstrateLengthAddition(
                        double value1,
                        LengthUnit unit1,
                        double value2,
                        LengthUnit unit2) {

                Length length1 = new Length(value1, unit1);

                Length length2 = new Length(value2, unit2);

                return length1.add(length2);
        }

        /**
         * UC7 - Addition with explicit target unit
         */
        public static Length demonstrateLengthAddition(
                        Length length1,
                        Length length2,
                        LengthUnit targetUnit) {

                return length1.add(length2, targetUnit);
        }

        public static void main(String[] args) {

                // =========================
                // UC5 - Unit Conversion
                // =========================

                Length length1 = new Length(1.0, LengthUnit.FEET);

                Length convertedLength1 = demonstrateLengthConversion(
                                length1,
                                LengthUnit.INCHES);

                System.out.println("Convert 1 FOOT to INCHES:");
                System.out.println(convertedLength1);

                Length length2 = new Length(3.0, LengthUnit.YARDS);

                Length convertedLength2 = demonstrateLengthConversion(
                                length2,
                                LengthUnit.FEET);

                System.out.println("Convert 3 YARDS to FEET:");
                System.out.println(convertedLength2);

                Length length3 = new Length(36.0, LengthUnit.INCHES);

                Length convertedLength3 = demonstrateLengthConversion(
                                length3,
                                LengthUnit.YARDS);

                System.out.println("Convert 36 INCHES to YARDS:");
                System.out.println(convertedLength3);

                Length length4 = new Length(2.54, LengthUnit.CENTIMETERS);

                Length convertedLength4 = demonstrateLengthConversion(
                                length4,
                                LengthUnit.INCHES);

                System.out.println("Convert 2.54 CM to INCHES:");
                System.out.println(convertedLength4);

                // =========================
                // UC6 - Length Addition
                // =========================

                System.out.println("\nUC6 - Length Addition");

                Length result1 = demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.FEET),
                                new Length(2.0, LengthUnit.FEET));

                System.out.println("1 FOOT + 2 FEET:");
                System.out.println(result1);

                Length result2 = demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.FEET),
                                new Length(12.0, LengthUnit.INCHES));

                System.out.println("1 FOOT + 12 INCHES:");
                System.out.println(result2);

                Length result3 = demonstrateLengthAddition(
                                new Length(12.0, LengthUnit.INCHES),
                                new Length(1.0, LengthUnit.FEET));

                System.out.println("12 INCHES + 1 FOOT:");
                System.out.println(result3);

                Length result4 = demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.YARDS),
                                new Length(3.0, LengthUnit.FEET));

                System.out.println("1 YARD + 3 FEET:");
                System.out.println(result4);

                Length result5 = demonstrateLengthAddition(
                                new Length(2.54, LengthUnit.CENTIMETERS),
                                new Length(1.0, LengthUnit.INCHES));

                System.out.println("2.54 CM + 1 INCH:");
                System.out.println(result5);

                // =========================
                // UC7 - Addition with Target Unit
                // =========================

                System.out.println("\nUC7 - Length Addition with Target Unit");

                Length result6 = demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.FEET),
                                new Length(12.0, LengthUnit.INCHES),
                                LengthUnit.FEET);

                System.out.println("1 FOOT + 12 INCHES in FEET:");
                System.out.println(result6);

                Length result7 = demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.FEET),
                                new Length(12.0, LengthUnit.INCHES),
                                LengthUnit.INCHES);

                System.out.println("1 FOOT + 12 INCHES in INCHES:");
                System.out.println(result7);
        }
}