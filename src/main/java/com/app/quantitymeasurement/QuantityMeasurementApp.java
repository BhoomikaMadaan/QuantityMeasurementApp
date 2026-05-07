package com.app.quantitymeasurement;

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

    public static void main(String[] args) {

        demonstrateFeetEquality();
        System.out.println();

        demonstrateInchesEquality();
        System.out.println();

        demonstrateFeetInchesComparison();
    }
}