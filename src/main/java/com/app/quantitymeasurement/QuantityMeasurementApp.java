//uc7 implementation 

package com.app.quantitymeasurement;

/**
 * UC5 - Unit to Unit Conversion
 */
public class QuantityMeasurementApp {

        // Equality demonstration
        public static boolean demonstrateLengthEquality(
                        Length length1,
                        Length length2) {

                return length1.equals(length2);
        }

        // Comparison demonstration
        public static boolean demonstrateLengthComparison(
                        double value1,
                        Length.LengthUnit unit1,
                        double value2,
                        Length.LengthUnit unit2) {

                Length length1 = new Length(value1, unit1);
                Length length2 = new Length(value2, unit2);

                return demonstrateLengthEquality(length1, length2);
        }

        // Conversion demonstration using raw values
        public static Length demonstrateLengthConversion(
                        double value,
                        Length.LengthUnit fromUnit,
                        Length.LengthUnit toUnit) {

                Length length = new Length(value, fromUnit);

                return length.convertTo(toUnit);
        }

        // Overloaded conversion method
        public static Length demonstrateLengthConversion(
                        Length length,
                        Length.LengthUnit toUnit) {

                return length.convertTo(toUnit);
        }

        // Addition demonstration using objects
        public static Length demonstrateLengthAddition(
                        Length length1,
                        Length length2) {

                return length1.add(length2);
        }

        // Overloaded addition method using raw values
        public static Length demonstrateLengthAddition(
                        double value1,
                        Length.LengthUnit unit1,
                        double value2,
                        Length.LengthUnit unit2) {

                Length length1 = new Length(value1, unit1);

                Length length2 = new Length(value2, unit2);

                return length1.add(length2);
        }

        /**
         * UC7 Implementation
         * Demonstrate addition of second QuantityLength to first QuantityLength
         * with target unit.
         *
         * @param length1    the first QuantityLength instance
         * @param length2    the second QuantityLength instance
         * @param targetUnit the target unit for the result
         * @return a new Length instance representing the sum of the two lengths
         *         in the target unit
         */
        public static Length demonstrateLengthAddition(
                        Length length1,
                        Length length2,
                        Length.LengthUnit targetUnit) {

                return length1.add(length2, targetUnit);
        }

        public static void main(String[] args) {

                // FEET to INCHES
                Length result1 = demonstrateLengthConversion(
                                1.0,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.INCHES);

                System.out.println("Convert 1 FOOT to INCHES:");
                System.out.println(result1);

                // YARDS to FEET
                Length result2 = demonstrateLengthConversion(
                                3.0,
                                Length.LengthUnit.YARDS,
                                Length.LengthUnit.FEET);

                System.out.println("Convert 3 YARDS to FEET:");
                System.out.println(result2);

                // INCHES to YARDS
                Length result3 = demonstrateLengthConversion(
                                36.0,
                                Length.LengthUnit.INCHES,
                                Length.LengthUnit.YARDS);

                System.out.println("Convert 36 INCHES to YARDS:");
                System.out.println(result3);

                // CENTIMETERS to INCHES
                Length result4 = demonstrateLengthConversion(
                                2.54,
                                Length.LengthUnit.CENTIMETERS,
                                Length.LengthUnit.INCHES);

                System.out.println("Convert 2.54 CM to INCHES:");
                System.out.println(result4);

                // uc6 addition to add the demo calls
                System.out.println();
                System.out.println("UC6 - Length Addition");

                // FEET + FEET
                Length addResult1 = demonstrateLengthAddition(
                                1.0,
                                Length.LengthUnit.FEET,
                                2.0,
                                Length.LengthUnit.FEET);

                System.out.println("1 FOOT + 2 FEET:");
                System.out.println(addResult1);

                // FEET + INCHES
                Length addResult2 = demonstrateLengthAddition(
                                1.0,
                                Length.LengthUnit.FEET,
                                12.0,
                                Length.LengthUnit.INCHES);

                System.out.println("1 FOOT + 12 INCHES:");
                System.out.println(addResult2);

                // INCHES + FEET
                Length addResult3 = demonstrateLengthAddition(
                                12.0,
                                Length.LengthUnit.INCHES,
                                1.0,
                                Length.LengthUnit.FEET);

                System.out.println("12 INCHES + 1 FOOT:");
                System.out.println(addResult3);

                // YARDS + FEET
                Length addResult4 = demonstrateLengthAddition(
                                1.0,
                                Length.LengthUnit.YARDS,
                                3.0,
                                Length.LengthUnit.FEET);

                System.out.println("1 YARD + 3 FEET:");
                System.out.println(addResult4);

                // CM + INCH
                Length addResult5 = demonstrateLengthAddition(
                                2.54,
                                Length.LengthUnit.CENTIMETERS,
                                1.0,
                                Length.LengthUnit.INCHES);

                System.out.println("2.54 CM + 1 INCH:");
                System.out.println(addResult5);

                System.out.println("\nUC7 - Length Addition with Target Unit");

                // FEET RESULT
                Length result5 = demonstrateLengthAddition(
                                new Length(1.0, Length.LengthUnit.FEET),
                                new Length(12.0, Length.LengthUnit.INCHES),
                                Length.LengthUnit.FEET);

                System.out.println("1 FOOT + 12 INCHES in FEET:");
                System.out.println(result5);

                // INCHES RESULT
                Length result6 = demonstrateLengthAddition(
                                new Length(1.0, Length.LengthUnit.FEET),
                                new Length(12.0, Length.LengthUnit.INCHES),
                                Length.LengthUnit.INCHES);

                System.out.println("1 FOOT + 12 INCHES in INCHES:");
                System.out.println(result6);
        }
}