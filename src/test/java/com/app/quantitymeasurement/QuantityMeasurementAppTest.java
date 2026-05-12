// package com.app.quantitymeasurement;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// public class QuantityMeasurementAppTest {

//     @Test
//     public void testFeetEquality() {

//         Length feet1 = new Length(1.0, Length.LengthUnit.FEET);

//         Length feet2 = new Length(1.0, Length.LengthUnit.FEET);

//         assertTrue(feet1.equals(feet2));
//     }

//     @Test
//     public void testInchesEquality() {

//         Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);

//         Length inch2 = new Length(1.0, Length.LengthUnit.INCHES);

//         assertTrue(inch1.equals(inch2));
//     }

//     @Test
//     public void testFeetInchesComparison() {

//         Length feet = new Length(1.0, Length.LengthUnit.FEET);

//         Length inches = new Length(12.0, Length.LengthUnit.INCHES);

//         assertTrue(feet.equals(inches));
//     }

//     @Test
//     public void testFeetInequality() {

//         Length feet1 = new Length(1.0, Length.LengthUnit.FEET);

//         Length feet2 = new Length(2.0, Length.LengthUnit.FEET);

//         assertFalse(feet1.equals(feet2));
//     }

//     @Test
//     public void testInchesInequality() {

//         Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);

//         Length inch2 = new Length(2.0, Length.LengthUnit.INCHES);

//         assertFalse(inch1.equals(inch2));
//     }

//     @Test
//     public void testCrossUnitInequality() {

//         Length feet = new Length(1.0, Length.LengthUnit.FEET);

//         Length inches = new Length(10.0, Length.LengthUnit.INCHES);

//         assertFalse(feet.equals(inches));
//     }

//     @Test
//     public void testMultipleFeetComparison() {

//         Length feet1 = new Length(3.0, Length.LengthUnit.FEET);

//         Length inches = new Length(36.0, Length.LengthUnit.INCHES);

//         assertTrue(feet1.equals(inches));
//     }

//     @Test
//     public void yardEquals36Inches() {

//         Length yard = new Length(1.0, Length.LengthUnit.YARDS);

//         Length inches = new Length(36.0, Length.LengthUnit.INCHES);

//         assertTrue(yard.equals(inches));
//     }

//     @Test
//     public void centimeterEquals39Point3701Inches() {

//         Length cm = new Length(100.0,
//                 Length.LengthUnit.CENTIMETERS);

//         Length inches = new Length(39.3701,
//                 Length.LengthUnit.INCHES);

//         assertTrue(cm.equals(inches));
//     }

//     @Test
//     public void threeFeetEqualsOneYard() {

//         Length feet = new Length(3.0,
//                 Length.LengthUnit.FEET);

//         Length yard = new Length(1.0,
//                 Length.LengthUnit.YARDS);

//         assertTrue(feet.equals(yard));
//     }

//     @Test
//     public void thirtyPoint48CmEqualsOneFoot() {

//         Length cm = new Length(30.48,
//                 Length.LengthUnit.CENTIMETERS);

//         Length foot = new Length(1.0,
//                 Length.LengthUnit.FEET);

//         assertTrue(cm.equals(foot));
//     }

//     @Test
//     public void yardNotEqualToInches() {

//         Length yard = new Length(1.0,
//                 Length.LengthUnit.YARDS);

//         Length inches = new Length(35.0,
//                 Length.LengthUnit.INCHES);

//         assertFalse(yard.equals(inches));
//     }

//     @Test
//     public void referenceEqualitySameObject() {

//         Length yard = new Length(1.0,
//                 Length.LengthUnit.YARDS);

//         assertTrue(yard.equals(yard));
//     }

//     @Test
//     public void equalsReturnsFalseForNull() {

//         Length yard = new Length(1.0,
//                 Length.LengthUnit.YARDS);

//         assertFalse(yard.equals(null));
//     }

//     @Test
//     public void reflexiveSymmetricAndTransitiveProperty() {

//         Length yard = new Length(1.0,
//                 Length.LengthUnit.YARDS);

//         Length feet = new Length(3.0,
//                 Length.LengthUnit.FEET);

//         Length inches = new Length(36.0,
//                 Length.LengthUnit.INCHES);

//         // Reflexive
//         assertTrue(yard.equals(yard));

//         // Symmetric
//         assertTrue(yard.equals(feet));
//         assertTrue(feet.equals(yard));

//         // Transitive
//         assertTrue(yard.equals(feet));
//         assertTrue(feet.equals(inches));
//         assertTrue(yard.equals(inches));
//     }

//     @Test
//     public void differentValuesSameUnitNotEqual() {

//         Length yard1 = new Length(1.0,
//                 Length.LengthUnit.YARDS);

//         Length yard2 = new Length(2.0,
//                 Length.LengthUnit.YARDS);

//         assertFalse(yard1.equals(yard2));
//     }

//     @Test
//     public void crossUnitEqualityDemonstrateMethod() {

//         Length yard = new Length(2.0,
//                 Length.LengthUnit.YARDS);

//         Length feet = new Length(6.0,
//                 Length.LengthUnit.FEET);

//         Length inches = new Length(72.0,
//                 Length.LengthUnit.INCHES);

//         assertTrue(yard.equals(feet));
//         assertTrue(feet.equals(inches));
//         assertTrue(yard.equals(inches));
//     }

//     @Test
//     public void nullUnitThrowsException() {

//         assertThrows(
//                 IllegalArgumentException.class,
//                 () -> new Length(1.0, null));
//     }
// }

//uc5

package com.app.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testConversion_FeetToInches() {

        double result = Length.convert(
                1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(12.0, result);
    }

    @Test
    public void testConversion_InchesToFeet() {

        double result = Length.convert(
                24.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET);

        assertEquals(2.0, result);
    }

    @Test
    public void testConversion_YardsToInches() {

        double result = Length.convert(
                1.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.INCHES);

        assertEquals(36.0, result);
    }

    @Test
    public void testConversion_InchesToYards() {

        double result = Length.convert(
                72.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.YARDS);

        assertEquals(2.0, result);
    }

    @Test
    public void testConversion_CentimetersToInches() {

        double result = Length.convert(
                2.54,
                Length.LengthUnit.CENTIMETERS,
                Length.LengthUnit.INCHES);

        assertEquals(1.0, result, 0.0001);
    }

    @Test
    public void testConversion_FeetToYards() {

        double result = Length.convert(
                6.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.YARDS);

        assertEquals(2.0, result);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {

        double result = Length.convert(
                Length.convert(
                        5.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES),
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET);

        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testConversion_ZeroValue() {

        double result = Length.convert(
                0.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(0.0, result);
    }

    @Test
    public void testConversion_NegativeValue() {

        double result = Length.convert(
                -1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(-12.0, result);
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> Length.convert(
                        1.0,
                        null,
                        Length.LengthUnit.INCHES));
    }

    @Test
    public void testConversion_NaN_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> Length.convert(
                        Double.NaN,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES));
    }

    @Test
    public void testConversion_Infinite_Throws() {

        assertThrows(
                IllegalArgumentException.class,
                () -> Length.convert(
                        Double.POSITIVE_INFINITY,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES));
    }

    @Test
    public void testConversion_PrecisionTolerance() {

        double result = Length.convert(
                1.0,
                Length.LengthUnit.CENTIMETERS,
                Length.LengthUnit.INCHES);

        assertEquals(0.393701, result, 0.0001);
    }

    @Test
    public void testConversion_SameUnit() {

        double result = Length.convert(
                5.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.FEET);

        assertEquals(5.0, result);
    }

    @Test
    public void testConversion_LargeValue() {

        double result = Length.convert(
                1000000.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(12000000.0, result);
    }

    @Test
    public void testConversion_SmallValue() {

        double result = Length.convert(
                0.0001,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(0.0012, result, 0.0001);
    }

    @Test
    public void testConversion_UsingConvertToMethod() {

        Length length = new Length(1.0, Length.LengthUnit.FEET);

        Length converted = length.convertTo(Length.LengthUnit.INCHES);

        Length expected = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(converted.equals(expected));
    }

    @Test
    public void testConversion_UsingOverloadedMethod() {

        Length length = new Length(2.0, Length.LengthUnit.YARDS);

        Length converted = QuantityMeasurementApp.demonstrateLengthConversion(
                length,
                Length.LengthUnit.INCHES);

        Length expected = new Length(72.0, Length.LengthUnit.INCHES);

        assertTrue(converted.equals(expected));
    }

    @Test
    public void convertZeroFeetToInches() {
        double result = Length.convert(0.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void convertNegativeFeetToInches() {
        double result = Length.convert(-1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(-12.0, result, 0.0001);
    }

    @Test
    public void convertInchesToFeet() {
        double result = Length.convert(24.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET);

        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void convertInchesToYards() {
        double result = Length.convert(72.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.YARDS);

        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void roundTripConversionPreservesValue() {

        double original = 5.0;

        double inches = Length.convert(original,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        double feet = Length.convert(inches,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET);

        assertEquals(original, feet, 0.0001);
    }
}