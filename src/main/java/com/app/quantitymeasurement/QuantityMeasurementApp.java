// package com.app.quantitymeasurement;

// import com.app.quantitymeasurement.Length.LengthUnit;

// public class QuantityMeasurementApp {

// public static boolean demonstrateLengthEquality(
// Length length1,
// Length length2) {

// return length1.equals(length2);
// }

// public static void demonstrateFeetEquality() {

// Length length1 = new Length(1.0, Length.LengthUnit.FEET);

// Length length2 = new Length(1.0, Length.LengthUnit.FEET);

// boolean result = demonstrateLengthEquality(length1, length2);

// System.out.println("Input: Quantity(1.0, feet) and Quantity(1.0, feet)");
// System.out.println("Output: " +
// (result ? "Equal (true)" : "Not Equal (false)"));
// }

// public static void demonstrateInchesEquality() {

// Length length1 = new Length(1.0, Length.LengthUnit.INCHES);

// Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

// boolean result = demonstrateLengthEquality(length1, length2);

// System.out.println("Input: Quantity(1.0, inches) and Quantity(1.0, inches)");
// System.out.println("Output: " +
// (result ? "Equal (true)" : "Not Equal (false)"));
// }

// public static void demonstrateFeetInchesComparison() {

// Length feet = new Length(1.0, Length.LengthUnit.FEET);

// Length inches = new Length(12.0, Length.LengthUnit.INCHES);

// boolean result = demonstrateLengthEquality(feet, inches);

// System.out.println("Input: Quantity(1.0, feet) and Quantity(12.0, inches)");
// System.out.println("Output: " +
// (result ? "Equal (true)" : "Not Equal (false)"));
// }

// public static void demonstrateYardsInchesComparison() {

// Length l1 = new Length(1.0, Length.LengthUnit.YARDS);

// Length l2 = new Length(36.0, Length.LengthUnit.INCHES);

// System.out.println("Input: Quantity(1.0, yards) and Quantity(36.0, inches)");

// System.out.println("Output: Equal (" + l1.equals(l2) + ")");
// }

// public static void demonstrateYardsFeetComparison() {

// Length l3 = new Length(3.0, Length.LengthUnit.FEET);

// Length l4 = new Length(1.0, Length.LengthUnit.YARDS);

// System.out.println("Input: Quantity(3.0, feet) and Quantity(1.0, yards)");

// System.out.println("Output: Equal (" + l3.equals(l4) + ")");
// }

// public static void demonstrateCentimetersInchesComparison() {

// Length l5 = new Length(1.0, Length.LengthUnit.CENTIMETERS);

// Length l6 = new Length(0.393701, Length.LengthUnit.INCHES);

// System.out.println("Input: Quantity(1.0, centimeters) and Quantity(0.393701,
// inches)");

// System.out.println("Output: Equal (" + l5.equals(l6) + ")");
// }

// public static void main(String[] args) {

// demonstrateFeetEquality();
// System.out.println();

// demonstrateInchesEquality();
// System.out.println();

// demonstrateFeetInchesComparison();
// System.out.println();

// // added the yards and inches for the UC4

// demonstrateYardsInchesComparison();
// System.out.println();

// demonstrateYardsFeetComparison();
// System.out.println();

// demonstrateCentimetersInchesComparison();
// System.out.println();
// }
// }

// uc5 implentation

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
    }
}