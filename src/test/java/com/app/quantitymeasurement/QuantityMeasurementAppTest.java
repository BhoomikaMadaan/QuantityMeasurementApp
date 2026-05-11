package com.app.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {
    @Test
    public void testEquality_FeetToFeet_SameValue() {

        Length length1 = new Length(1.0, Length.LengthUnit.FEET);

        Length length2 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_InchToInch_SameValue() {

        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);

        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);

        assertTrue(length1.equals(length2));
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);

        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {

        Length length1 = new Length(1.0, Length.LengthUnit.FEET);

        Length length2 = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {

        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);

        Length length2 = new Length(2.0, Length.LengthUnit.INCHES);

        assertFalse(length1.equals(length2));
    }

    @Test
    public void testEquality_NullComparison() {

        Length length = new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(length.equals(null));
    }

    @Test
    public void testEquality_SameReference() {

        Length length = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(length.equals(length));
    }

    @Test
    public void yardEquals36Inches() {

        Length yard = new Length(1.0, Length.LengthUnit.YARDS);

        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yard.equals(inches));
    }

    @Test
    public void threeFeetEqualsOneYard() {

        Length feet = new Length(3.0, Length.LengthUnit.FEET);

        Length yard = new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(feet.equals(yard));
    }

    @Test
    public void centimeterEqualsPoint393701Inches() {

        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);

        Length inches = new Length(0.393701, Length.LengthUnit.INCHES);

        assertTrue(cm.equals(inches));
    }

    @Test
    public void yardNotEqualToInches() {

        Length yard = new Length(1.0, Length.LengthUnit.YARDS);

        Length inches = new Length(35.0, Length.LengthUnit.INCHES);

        assertFalse(yard.equals(inches));
    }

    @Test
    public void equalsReturnsFalseForNull() {

        Length yard = new Length(1.0, Length.LengthUnit.YARDS);

        assertFalse(yard.equals(null));
    }

}