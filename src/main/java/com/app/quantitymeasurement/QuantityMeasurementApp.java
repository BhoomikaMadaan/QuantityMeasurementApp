package com.app.quantitymeasurement;

import com.app.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(
            Length length1,
            Length length2) {

        return length1.equals(length2);
    }

    public static void demonstrateFeetEquality() {

        Length length1 = new Length(1.0, Length.LengthUnit.FEET);

        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        boolean result = demonstrateLengthEquality(length1, length2);

        System.out.println("Input: Quantity(1.0, feet) and Quantity(1.0, feet)");
        System.out.println("Output: " +
                (result ? "Equal (true)" : "Not Equal (false)"));
    }

    public static void demonstrateInchesEquality() {

        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);

        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

        boolean result = demonstrateLengthEquality(length1, length2);

        System.out.println("Input: Quantity(1.0, inches) and Quantity(1.0, inches)");
        System.out.println("Output: " +
                (result ? "Equal (true)" : "Not Equal (false)"));
    }

    public static void demonstrateFeetInchesComparison() {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);

        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        boolean result = demonstrateLengthEquality(feet, inches);

        System.out.println("Input: Quantity(1.0, feet) and Quantity(12.0, inches)");
        System.out.println("Output: " +
                (result ? "Equal (true)" : "Not Equal (false)"));
    }

    public static void demonstrateYardsInchesComparison() {

        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);

        Length l2 = new Length(36.0, Length.LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, yards) and Quantity(36.0, inches)");

        System.out.println("Output: Equal (" + l1.equals(l2) + ")");
    }

    public static void demonstrateYardsFeetComparison() {

        Length l3 = new Length(3.0, Length.LengthUnit.FEET);

        Length l4 = new Length(1.0, Length.LengthUnit.YARDS);

        System.out.println("Input: Quantity(3.0, feet) and Quantity(1.0, yards)");

        System.out.println("Output: Equal (" + l3.equals(l4) + ")");
    }

    public static void demonstrateCentimetersInchesComparison() {

        Length l5 = new Length(1.0, Length.LengthUnit.CENTIMETERS);

        Length l6 = new Length(0.393701, Length.LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, centimeters) and Quantity(0.393701, inches)");

        System.out.println("Output: Equal (" + l5.equals(l6) + ")");
    }

    public static void main(String[] args) {

        demonstrateFeetEquality();
        System.out.println();

        demonstrateInchesEquality();
        System.out.println();

        demonstrateFeetInchesComparison();
        System.out.println();

        // added the yards and inches for the UC4

        demonstrateYardsInchesComparison();
        System.out.println();

        demonstrateYardsFeetComparison();
        System.out.println();

        demonstrateCentimetersInchesComparison();
        System.out.println();
    }
}