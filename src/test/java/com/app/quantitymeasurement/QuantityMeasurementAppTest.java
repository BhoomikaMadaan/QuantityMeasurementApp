// package com.app.quantitymeasurement;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// public class QuantityMeasurementAppTest {

//     @Test
//     public void testFeetEquality() {

//         Length feet1 = new Length(1.0, LengthUnit.FEET);

//         Length feet2 = new Length(1.0, LengthUnit.FEET);

//         assertTrue(feet1.equals(feet2));
//     }

//     @Test
//     public void testInchesEquality() {

//         Length inch1 = new Length(1.0, LengthUnit.INCHES);

//         Length inch2 = new Length(1.0, LengthUnit.INCHES);

//         assertTrue(inch1.equals(inch2));
//     }

//     @Test
//     public void testFeetInchesComparison() {

//         Length feet = new Length(1.0, LengthUnit.FEET);

//         Length inches = new Length(12.0, LengthUnit.INCHES);

//         assertTrue(feet.equals(inches));
//     }

//     @Test
//     public void testFeetInequality() {

//         Length feet1 = new Length(1.0, LengthUnit.FEET);

//         Length feet2 = new Length(2.0, LengthUnit.FEET);

//         assertFalse(feet1.equals(feet2));
//     }

//     @Test
//     public void testInchesInequality() {

//         Length inch1 = new Length(1.0, LengthUnit.INCHES);

//         Length inch2 = new Length(2.0, LengthUnit.INCHES);

//         assertFalse(inch1.equals(inch2));
//     }

//     @Test
//     public void testCrossUnitInequality() {

//         Length feet = new Length(1.0, LengthUnit.FEET);

//         Length inches = new Length(10.0, LengthUnit.INCHES);

//         assertFalse(feet.equals(inches));
//     }

//     @Test
//     public void testMultipleFeetComparison() {

//         Length feet1 = new Length(3.0, LengthUnit.FEET);

//         Length inches = new Length(36.0, LengthUnit.INCHES);

//         assertTrue(feet1.equals(inches));
//     }

//     @Test
//     public void yardEquals36Inches() {

//         Length yard = new Length(1.0, LengthUnit.YARDS);

//         Length inches = new Length(36.0, LengthUnit.INCHES);

//         assertTrue(yard.equals(inches));
//     }

//     @Test
//     public void centimeterEquals39Point3701Inches() {

//         Length cm = new Length(100.0,
//                 LengthUnit.CENTIMETERS);

//         Length inches = new Length(39.3701,
//                 LengthUnit.INCHES);

//         assertTrue(cm.equals(inches));
//     }

//     @Test
//     public void threeFeetEqualsOneYard() {

//         Length feet = new Length(3.0,
//                 LengthUnit.FEET);

//         Length yard = new Length(1.0,
//                 LengthUnit.YARDS);

//         assertTrue(feet.equals(yard));
//     }

//     @Test
//     public void thirtyPoint48CmEqualsOneFoot() {

//         Length cm = new Length(30.48,
//                 LengthUnit.CENTIMETERS);

//         Length foot = new Length(1.0,
//                 LengthUnit.FEET);

//         assertTrue(cm.equals(foot));
//     }

//     @Test
//     public void yardNotEqualToInches() {

//         Length yard = new Length(1.0,
//                 LengthUnit.YARDS);

//         Length inches = new Length(35.0,
//                 LengthUnit.INCHES);

//         assertFalse(yard.equals(inches));
//     }

//     @Test
//     public void referenceEqualitySameObject() {

//         Length yard = new Length(1.0,
//                 LengthUnit.YARDS);

//         assertTrue(yard.equals(yard));
//     }

//     @Test
//     public void equalsReturnsFalseForNull() {

//         Length yard = new Length(1.0,
//                 LengthUnit.YARDS);

//         assertFalse(yard.equals(null));
//     }

//     @Test
//     public void reflexiveSymmetricAndTransitiveProperty() {

//         Length yard = new Length(1.0,
//                 LengthUnit.YARDS);

//         Length feet = new Length(3.0,
//                 LengthUnit.FEET);

//         Length inches = new Length(36.0,
//                 LengthUnit.INCHES);

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
//                 LengthUnit.YARDS);

//         Length yard2 = new Length(2.0,
//                 LengthUnit.YARDS);

//         assertFalse(yard1.equals(yard2));
//     }

//     @Test
//     public void crossUnitEqualityDemonstrateMethod() {

//         Length yard = new Length(2.0,
//                 LengthUnit.YARDS);

//         Length feet = new Length(6.0,
//                 LengthUnit.FEET);

//         Length inches = new Length(72.0,
//                 LengthUnit.INCHES);

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
                                LengthUnit.FEET,
                                LengthUnit.INCHES);

                assertEquals(12.0, result);
        }

        @Test
        public void testConversion_InchesToFeet() {

                double result = Length.convert(
                                24.0,
                                LengthUnit.INCHES,
                                LengthUnit.FEET);

                assertEquals(2.0, result);
        }

        @Test
        public void testConversion_YardsToInches() {

                double result = Length.convert(
                                1.0,
                                LengthUnit.YARDS,
                                LengthUnit.INCHES);

                assertEquals(36.0, result);
        }

        @Test
        public void testConversion_InchesToYards() {

                double result = Length.convert(
                                72.0,
                                LengthUnit.INCHES,
                                LengthUnit.YARDS);

                assertEquals(2.0, result);
        }

        @Test
        public void testConversion_CentimetersToInches() {

                double result = Length.convert(
                                2.54,
                                LengthUnit.CENTIMETERS,
                                LengthUnit.INCHES);

                assertEquals(1.0, result, 0.0001);
        }

        @Test
        public void testConversion_FeetToYards() {

                double result = Length.convert(
                                6.0,
                                LengthUnit.FEET,
                                LengthUnit.YARDS);

                assertEquals(2.0, result);
        }

        @Test
        public void testConversion_RoundTrip_PreservesValue() {

                double result = Length.convert(
                                Length.convert(
                                                5.0,
                                                LengthUnit.FEET,
                                                LengthUnit.INCHES),
                                LengthUnit.INCHES,
                                LengthUnit.FEET);

                assertEquals(5.0, result, 0.0001);
        }

        @Test
        public void testConversion_ZeroValue() {

                double result = Length.convert(
                                0.0,
                                LengthUnit.FEET,
                                LengthUnit.INCHES);

                assertEquals(0.0, result);
        }

        @Test
        public void testConversion_NegativeValue() {

                double result = Length.convert(
                                -1.0,
                                LengthUnit.FEET,
                                LengthUnit.INCHES);

                assertEquals(-12.0, result);
        }

        @Test
        public void testConversion_InvalidUnit_Throws() {

                assertThrows(
                                IllegalArgumentException.class,
                                () -> Length.convert(
                                                1.0,
                                                null,
                                                LengthUnit.INCHES));
        }

        @Test
        public void testConversion_NaN_Throws() {

                assertThrows(
                                IllegalArgumentException.class,
                                () -> Length.convert(
                                                Double.NaN,
                                                LengthUnit.FEET,
                                                LengthUnit.INCHES));
        }

        @Test
        public void testConversion_Infinite_Throws() {

                assertThrows(
                                IllegalArgumentException.class,
                                () -> Length.convert(
                                                Double.POSITIVE_INFINITY,
                                                LengthUnit.FEET,
                                                LengthUnit.INCHES));
        }

        @Test
        public void testConversion_PrecisionTolerance() {

                double result = Length.convert(
                                1.0,
                                LengthUnit.CENTIMETERS,
                                LengthUnit.INCHES);

                assertEquals(0.393701, result, 0.0001);
        }

        @Test
        public void testConversion_SameUnit() {

                double result = Length.convert(
                                5.0,
                                LengthUnit.FEET,
                                LengthUnit.FEET);

                assertEquals(5.0, result);
        }

        @Test
        public void testConversion_LargeValue() {

                double result = Length.convert(
                                1000000.0,
                                LengthUnit.FEET,
                                LengthUnit.INCHES);

                assertEquals(12000000.0, result);
        }

        @Test
        public void testConversion_SmallValue() {

                double result = Length.convert(
                                0.0001,
                                LengthUnit.FEET,
                                LengthUnit.INCHES);

                assertEquals(0.0012, result, 0.0001);
        }

        @Test
        public void testConversion_UsingConvertToMethod() {

                Length length = new Length(1.0, LengthUnit.FEET);

                Length converted = length.convertTo(LengthUnit.INCHES);

                Length expected = new Length(12.0, LengthUnit.INCHES);

                assertTrue(converted.equals(expected));
        }

        @Test
        public void testConversion_UsingOverloadedMethod() {

                Length length = new Length(2.0, LengthUnit.YARDS);

                Length converted = QuantityMeasurementApp.demonstrateLengthConversion(
                                length,
                                LengthUnit.INCHES);

                Length expected = new Length(72.0, LengthUnit.INCHES);

                assertTrue(converted.equals(expected));
        }

        @Test
        public void convertZeroFeetToInches() {
                double result = Length.convert(0.0,
                                LengthUnit.FEET,
                                LengthUnit.INCHES);

                assertEquals(0.0, result, 0.0001);
        }

        @Test
        public void convertNegativeFeetToInches() {
                double result = Length.convert(-1.0,
                                LengthUnit.FEET,
                                LengthUnit.INCHES);

                assertEquals(-12.0, result, 0.0001);
        }

        @Test
        public void convertInchesToFeet() {
                double result = Length.convert(24.0,
                                LengthUnit.INCHES,
                                LengthUnit.FEET);

                assertEquals(2.0, result, 0.0001);
        }

        @Test
        public void convertInchesToYards() {
                double result = Length.convert(72.0,
                                LengthUnit.INCHES,
                                LengthUnit.YARDS);

                assertEquals(2.0, result, 0.0001);
        }

        @Test
        public void roundTripConversionPreservesValue() {

                double original = 5.0;

                double inches = Length.convert(original,
                                LengthUnit.FEET,
                                LengthUnit.INCHES);

                double feet = Length.convert(inches,
                                LengthUnit.INCHES,
                                LengthUnit.FEET);

                assertEquals(original, feet, 0.0001);

        }

        // uc6 test cases
        @Test
        public void addFeetToFeet() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                1.0,
                                LengthUnit.FEET,
                                2.0,
                                LengthUnit.FEET);

                Length expected = new Length(3.0, LengthUnit.FEET);

                assertTrue(result.equals(expected));
        }

        @Test
        public void addFeetToInches() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                1.0,
                                LengthUnit.FEET,
                                12.0,
                                LengthUnit.INCHES);

                Length expected = new Length(2.0, LengthUnit.FEET);

                assertTrue(result.equals(expected));
        }

        @Test
        public void addInchesToFeet() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                12.0,
                                LengthUnit.INCHES,
                                1.0,
                                LengthUnit.FEET);

                Length expected = new Length(24.0, LengthUnit.INCHES);

                assertTrue(result.equals(expected));
        }

        @Test
        public void addYardsToFeet() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                1.0,
                                LengthUnit.YARDS,
                                3.0,
                                LengthUnit.FEET);

                Length expected = new Length(2.0, LengthUnit.YARDS);

                assertTrue(result.equals(expected));
        }

        @Test
        public void addCentimetersToInches() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                2.54,
                                LengthUnit.CENTIMETERS,
                                1.0,
                                LengthUnit.INCHES);

                Length expected = new Length(5.08, LengthUnit.CENTIMETERS);

                assertEquals(
                                expected.convertTo(LengthUnit.INCHES)
                                                .getValue(),
                                result.convertTo(LengthUnit.INCHES)
                                                .getValue(),
                                0.01);
        }

        @Test
        public void addZeroValues() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                0.0,
                                LengthUnit.FEET,
                                0.0,
                                LengthUnit.FEET);

                Length expected = new Length(0.0, LengthUnit.FEET);

                assertTrue(result.equals(expected));
        }

        @Test
        public void addNegativeValues() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                -1.0,
                                LengthUnit.FEET,
                                1.0,
                                LengthUnit.FEET);

                Length expected = new Length(0.0, LengthUnit.FEET);

                assertTrue(result.equals(expected));
        }

        @Test
        public void addSameUnitReturnsCorrectUnit() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                5.0,
                                LengthUnit.FEET,
                                5.0,
                                LengthUnit.FEET);

                assertEquals(
                                LengthUnit.FEET,
                                result.getUnit());
        }

        @Test
        public void additionPreservesFirstOperandUnit() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                12.0,
                                LengthUnit.INCHES,
                                1.0,
                                LengthUnit.FEET);

                assertEquals(
                                LengthUnit.INCHES,
                                result.getUnit());
        }

        @Test
        public void addLargeValues() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                1000000.0,
                                LengthUnit.FEET,
                                1000000.0,
                                LengthUnit.FEET);

                Length expected = new Length(2000000.0, LengthUnit.FEET);

                assertTrue(result.equals(expected));
        }

        @Test
        public void addSmallDecimalValues() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                0.5,
                                LengthUnit.FEET,
                                0.5,
                                LengthUnit.FEET);

                Length expected = new Length(1.0, LengthUnit.FEET);

                assertTrue(result.equals(expected));
        }

        @Test
        public void additionIsCommutativeForEquivalentUnits() {

                Length result1 = QuantityMeasurementApp.demonstrateLengthAddition(
                                1.0,
                                LengthUnit.FEET,
                                12.0,
                                LengthUnit.INCHES);

                Length result2 = QuantityMeasurementApp.demonstrateLengthAddition(
                                12.0,
                                LengthUnit.INCHES,
                                1.0,
                                LengthUnit.FEET);

                assertTrue(
                                result1.equals(result2));
        }

        @Test
        public void addSameObjectReference() {

                Length length = new Length(1.0, LengthUnit.FEET);

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                length,
                                length);

                Length expected = new Length(2.0, LengthUnit.FEET);

                assertTrue(result.equals(expected));
        }

        // UC7 implementtaion of the test cASES
        @Test
        public void testAddition_ExplicitTargetUnit_Yards() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.FEET),
                                new Length(12.0, LengthUnit.INCHES),
                                LengthUnit.YARDS);

                Length expected = new Length(0.67, LengthUnit.YARDS);

                assertEquals(
                                expected.getValue(),
                                result.getValue(),
                                0.01);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_Centimeters() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.INCHES),
                                new Length(1.0, LengthUnit.INCHES),
                                LengthUnit.CENTIMETERS);

                Length expected = new Length(5.08, LengthUnit.CENTIMETERS);

                assertEquals(
                                expected.getValue(),
                                result.getValue(),
                                0.01);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(2.0, LengthUnit.YARDS),
                                new Length(3.0, LengthUnit.FEET),
                                LengthUnit.YARDS);

                Length expected = new Length(3.0, LengthUnit.YARDS);

                assertTrue(result.equals(expected));
        }

        @Test
        public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(2.0, LengthUnit.YARDS),
                                new Length(3.0, LengthUnit.FEET),
                                LengthUnit.FEET);

                Length expected = new Length(9.0, LengthUnit.FEET);

                assertTrue(result.equals(expected));
        }

        @Test
        public void testAddition_ExplicitTargetUnit_Commutativity() {

                Length result1 = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.FEET),
                                new Length(12.0, LengthUnit.INCHES),
                                LengthUnit.YARDS);

                Length result2 = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(12.0, LengthUnit.INCHES),
                                new Length(1.0, LengthUnit.FEET),
                                LengthUnit.YARDS);

                assertEquals(
                                result1.getValue(),
                                result2.getValue(),
                                0.01);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_WithZero() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(5.0, LengthUnit.FEET),
                                new Length(0.0, LengthUnit.INCHES),
                                LengthUnit.YARDS);

                Length expected = new Length(1.67, LengthUnit.YARDS);

                assertEquals(
                                expected.getValue(),
                                result.getValue(),
                                0.01);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_NegativeValues() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(5.0, LengthUnit.FEET),
                                new Length(-2.0, LengthUnit.FEET),
                                LengthUnit.INCHES);

                Length expected = new Length(36.0, LengthUnit.INCHES);

                assertTrue(result.equals(expected));
        }

        @Test
        public void testAddition_ExplicitTargetUnit_NullTargetUnit() {

                assertThrows(
                                IllegalArgumentException.class,
                                () -> QuantityMeasurementApp.demonstrateLengthAddition(
                                                new Length(1.0, LengthUnit.FEET),
                                                new Length(12.0, LengthUnit.INCHES),
                                                null));
        }

        @Test
        public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(1000.0, LengthUnit.FEET),
                                new Length(500.0, LengthUnit.FEET),
                                LengthUnit.INCHES);

                Length expected = new Length(18000.0, LengthUnit.INCHES);

                assertTrue(result.equals(expected));
        }

        @Test
        public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(12.0, LengthUnit.INCHES),
                                new Length(12.0, LengthUnit.INCHES),
                                LengthUnit.YARDS);

                Length expected = new Length(0.67, LengthUnit.YARDS);

                assertEquals(
                                expected.getValue(),
                                result.getValue(),
                                0.01);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_PrecisionTolerance() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(2.54, LengthUnit.CENTIMETERS),
                                new Length(1.0, LengthUnit.INCHES),
                                LengthUnit.CENTIMETERS);

                assertEquals(
                                5.08,
                                result.getValue(),
                                0.01);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_Feet() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.FEET),
                                new Length(12.0, LengthUnit.INCHES),
                                LengthUnit.FEET);

                Length expected = new Length(2.0, LengthUnit.FEET);

                assertTrue(result.equals(expected));
        }

        @Test
        public void testAddition_ExplicitTargetUnit_Inches() {

                Length result = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.FEET),
                                new Length(12.0, LengthUnit.INCHES),
                                LengthUnit.INCHES);

                Length expected = new Length(24.0, LengthUnit.INCHES);

                assertTrue(result.equals(expected));
        }

        @Test
        public void testAddition_ExplicitTargetUnit_AllUnitCombinations() {

                Length result1 = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.FEET),
                                new Length(12.0, LengthUnit.INCHES),
                                LengthUnit.FEET);

                Length result2 = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(1.0, LengthUnit.YARDS),
                                new Length(3.0, LengthUnit.FEET),
                                LengthUnit.YARDS);

                Length result3 = QuantityMeasurementApp.demonstrateLengthAddition(
                                new Length(2.54, LengthUnit.CENTIMETERS),
                                new Length(1.0, LengthUnit.INCHES),
                                LengthUnit.CENTIMETERS);

                assertEquals(2.0, result1.getValue(), 0.01);

                assertEquals(2.0, result2.getValue(), 0.01);

                assertEquals(5.08, result3.getValue(), 0.01);
        }

        // UC9 test cases
        @Test
        public void testEquality_KilogramToKilogram_SameValue() {

                QuantityWeight weight1 = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight weight2 = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                assertTrue(weight1.equals(weight2));
        }

        // cross-unit equality
        @Test
        public void testEquality_KilogramToGram_EquivalentValue() {

                QuantityWeight weight1 = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight weight2 = new QuantityWeight(
                                1000.0,
                                WeightUnit.GRAM);

                assertTrue(weight1.equals(weight2));
        }

        // type safety test
        @Test
        public void testEquality_WeightVsLength_Incompatible() {

                QuantityWeight weight = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                Length length = new Length(
                                1.0,
                                LengthUnit.FEET);

                assertFalse(weight.equals(length));
        }

        // null comparison

        @Test
        public void testEquality_NullComparison() {

                QuantityWeight weight = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                assertFalse(weight.equals(null));
        }

        // same reference
        @Test
        public void testEquality_SameReference() {

                QuantityWeight weight = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                assertTrue(weight.equals(weight));
        }

        // null unit validation
        @Test
        public void testEquality_NullUnit() {

                assertThrows(
                                IllegalArgumentException.class,

                                () -> new QuantityWeight(
                                                1.0,
                                                null));
        }

        // pound to kilo conversion

        @Test
        public void testConversion_PoundToKilogram() {

                QuantityWeight weight = new QuantityWeight(
                                2.20462,
                                WeightUnit.POUND);

                QuantityWeight converted = weight.convertTo(
                                WeightUnit.KILOGRAM);

                assertEquals(
                                1.0,
                                converted.getValue(),
                                0.01);
        }

        // kilogram to pound conversion
        @Test
        public void testConversion_KilogramToPound() {

                QuantityWeight weight = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight converted = weight.convertTo(
                                WeightUnit.POUND);

                assertEquals(
                                2.20462,
                                converted.getValue(),
                                0.01);
        }

        // same unit conversion
        @Test
        public void testConversion_SameUnit() {

                QuantityWeight weight = new QuantityWeight(
                                5.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight converted = weight.convertTo(
                                WeightUnit.KILOGRAM);

                assertEquals(
                                5.0,
                                converted.getValue(),
                                0.01);
        }

        // round-trip conversion
        @Test
        public void testConversion_RoundTrip() {

                QuantityWeight weight = new QuantityWeight(
                                1.5,
                                WeightUnit.KILOGRAM);

                QuantityWeight converted = weight.convertTo(WeightUnit.GRAM)
                                .convertTo(WeightUnit.KILOGRAM);

                assertEquals(
                                1.5,
                                converted.getValue(),
                                0.01);
        }

        // same unit addition
        @Test
        public void testAddition_SameUnit_KilogramPlusKilogram() {

                QuantityWeight weight1 = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight weight2 = new QuantityWeight(
                                2.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight result = weight1.add(weight2);

                assertEquals(
                                3.0,
                                result.getValue(),
                                0.01);
        }

        // cross unit addition
        @Test
        public void testAddition_CrossUnit_KilogramPlusGram() {

                QuantityWeight weight1 = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight weight2 = new QuantityWeight(
                                1000.0,
                                WeightUnit.GRAM);

                QuantityWeight result = weight1.add(weight2);

                assertEquals(
                                2.0,
                                result.getValue(),
                                0.01);
        }

        // explicit target unit addition
        @Test
        public void testAddition_ExplicitTargetUnit_Kilogram() {

                QuantityWeight weight1 = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight weight2 = new QuantityWeight(
                                1000.0,
                                WeightUnit.GRAM);

                QuantityWeight result = weight1.add(
                                weight2,
                                WeightUnit.GRAM);

                assertEquals(
                                2000.0,
                                result.getValue(),
                                0.01);
        }

        // addition commutativity
        @Test
        public void testAddition_Commutativity() {

                QuantityWeight weight1 = new QuantityWeight(
                                1.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight weight2 = new QuantityWeight(
                                1000.0,
                                WeightUnit.GRAM);

                QuantityWeight result1 = weight1.add(weight2);

                QuantityWeight result2 = weight2.add(weight1);

                assertEquals(
                                result1.convertTo(WeightUnit.KILOGRAM)
                                                .getValue(),

                                result2.convertTo(WeightUnit.KILOGRAM)
                                                .getValue(),

                                0.01);
        }

        // zero value addition
        @Test
        public void testAddition_WithZero() {

                QuantityWeight weight1 = new QuantityWeight(
                                5.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight weight2 = new QuantityWeight(
                                0.0,
                                WeightUnit.GRAM);

                QuantityWeight result = weight1.add(weight2);

                assertEquals(
                                5.0,
                                result.getValue(),
                                0.01);
        }

        // -ve values
        @Test
        public void testAddition_NegativeValues() {

                QuantityWeight weight1 = new QuantityWeight(
                                5.0,
                                WeightUnit.KILOGRAM);

                QuantityWeight weight2 = new QuantityWeight(
                                -2000.0,
                                WeightUnit.GRAM);

                QuantityWeight result = weight1.add(weight2);

                assertEquals(
                                3.0,
                                result.getValue(),
                                0.01);
        }
}