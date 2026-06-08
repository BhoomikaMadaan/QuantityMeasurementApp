package com.app.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

        // =========================
        // UC1–UC4 Equality Tests
        // =========================

        @Test
        public void testFeetEquality() {

                Quantity<LengthUnit> feet1 = new Quantity<>(1.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> feet2 = new Quantity<>(1.0,
                                LengthUnit.FEET);

                assertTrue(feet1.equals(feet2));
        }

        @Test
        public void testFeetInchesComparison() {

                Quantity<LengthUnit> feet = new Quantity<>(1.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> inches = new Quantity<>(12.0,
                                LengthUnit.INCHES);

                assertTrue(feet.equals(inches));
        }

        @Test
        public void testCrossUnitInequality() {

                Quantity<LengthUnit> feet = new Quantity<>(1.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> inches = new Quantity<>(10.0,
                                LengthUnit.INCHES);

                assertFalse(feet.equals(inches));
        }

        @Test
        public void testNullUnitThrowsException() {

                assertThrows(
                                IllegalArgumentException.class,

                                () -> new Quantity<>(
                                                1.0,
                                                null));
        }

        // =========================
        // UC5 Conversion Tests
        // =========================

        @Test
        public void testConversion_FeetToInches() {

                Quantity<LengthUnit> feet = new Quantity<>(1.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> converted = feet.convertTo(
                                LengthUnit.INCHES);

                assertEquals(
                                12.0,
                                converted.getValue(),
                                0.01);
        }

        @Test
        public void testConversion_YardsToFeet() {

                Quantity<LengthUnit> yard = new Quantity<>(1.0,
                                LengthUnit.YARDS);

                Quantity<LengthUnit> converted = yard.convertTo(
                                LengthUnit.FEET);

                assertEquals(
                                3.0,
                                converted.getValue(),
                                0.01);
        }

        // =========================
        // UC6 Addition Tests
        // =========================

        @Test
        public void addFeetToFeet() {

                Quantity<LengthUnit> length1 = new Quantity<>(1.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> length2 = new Quantity<>(2.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> result = length1.add(length2);

                assertEquals(
                                3.0,
                                result.getValue(),
                                0.01);
        }

        @Test
        public void addFeetToInches() {

                Quantity<LengthUnit> length1 = new Quantity<>(1.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> length2 = new Quantity<>(12.0,
                                LengthUnit.INCHES);

                Quantity<LengthUnit> result = length1.add(length2);

                assertEquals(
                                2.0,
                                result.getValue(),
                                0.01);
        }

        // =========================
        // UC7 Explicit Target Unit
        // =========================

        @Test
        public void testAddition_ExplicitTargetUnit_Feet() {

                Quantity<LengthUnit> length1 = new Quantity<>(1.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> length2 = new Quantity<>(12.0,
                                LengthUnit.INCHES);

                Quantity<LengthUnit> result = length1.add(
                                length2,
                                LengthUnit.FEET);

                assertEquals(
                                2.0,
                                result.getValue(),
                                0.01);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_Inches() {

                Quantity<LengthUnit> length1 = new Quantity<>(1.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> length2 = new Quantity<>(12.0,
                                LengthUnit.INCHES);

                Quantity<LengthUnit> result = length1.add(
                                length2,
                                LengthUnit.INCHES);

                assertEquals(
                                24.0,
                                result.getValue(),
                                0.01);
        }

        @Test
        public void testAddition_ExplicitTargetUnit_Yards() {

                Quantity<LengthUnit> length1 = new Quantity<>(1.0,
                                LengthUnit.FEET);

                Quantity<LengthUnit> length2 = new Quantity<>(12.0,
                                LengthUnit.INCHES);

                Quantity<LengthUnit> result = length1.add(
                                length2,
                                LengthUnit.YARDS);

                assertEquals(
                                0.67,
                                result.getValue(),
                                0.01);
        }

        // =========================
        // UC9 Weight Tests
        // =========================

        @Test
        public void testWeightEquality() {

                Quantity<WeightUnit> weight1 = new Quantity<>(1.0,
                                WeightUnit.KILOGRAM);

                Quantity<WeightUnit> weight2 = new Quantity<>(1000.0,
                                WeightUnit.GRAM);

                assertTrue(weight1.equals(weight2));
        }

        @Test
        public void testWeightConversion() {

                Quantity<WeightUnit> weight = new Quantity<>(1.0,
                                WeightUnit.KILOGRAM);

                Quantity<WeightUnit> converted = weight.convertTo(
                                WeightUnit.GRAM);

                assertEquals(
                                1000.0,
                                converted.getValue(),
                                0.01);
        }

        @Test
        public void testWeightAddition() {

                Quantity<WeightUnit> weight1 = new Quantity<>(1.0,
                                WeightUnit.KILOGRAM);

                Quantity<WeightUnit> weight2 = new Quantity<>(1000.0,
                                WeightUnit.GRAM);

                Quantity<WeightUnit> result = weight1.add(weight2);

                assertEquals(
                                2.0,
                                result.getValue(),
                                0.01);
        }

        // =========================
        // Cross Category Safety
        // =========================

        @Test
        public void testWeightVsLength_Incompatible() {

                Quantity<WeightUnit> weight = new Quantity<>(1.0,
                                WeightUnit.KILOGRAM);

                Quantity<LengthUnit> length = new Quantity<>(1.0,
                                LengthUnit.FEET);

                assertFalse(weight.equals(length));
        }

        // =========================
        // Null Validation
        // =========================

        @Test
        public void testNullComparison() {

                Quantity<WeightUnit> weight = new Quantity<>(1.0,
                                WeightUnit.KILOGRAM);

                assertFalse(weight.equals(null));
        }

        // =========================
        // Commutativity
        // =========================

        @Test
        public void testAdditionCommutativity() {

                Quantity<WeightUnit> weight1 = new Quantity<>(1.0,
                                WeightUnit.KILOGRAM);

                Quantity<WeightUnit> weight2 = new Quantity<>(1000.0,
                                WeightUnit.GRAM);

                Quantity<WeightUnit> result1 = weight1.add(weight2);

                Quantity<WeightUnit> result2 = weight2.add(weight1);

                assertEquals(
                                result1.convertTo(
                                                WeightUnit.KILOGRAM)
                                                .getValue(),

                                result2.convertTo(
                                                WeightUnit.KILOGRAM)
                                                .getValue(),

                                0.01);
        }

        // =========================
        // UC11 Volume Tests
        // =========================

        @Test
        public void testVolumeEquality() {

                Quantity<VolumeUnit> volume1 = new Quantity<>(1.0,
                                VolumeUnit.LITRE);

                Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0,
                                VolumeUnit.MILLILITRE);

                assertTrue(volume1.equals(volume2));
        }

        @Test
        public void testVolumeConversion_LitreToMillilitre() {

                Quantity<VolumeUnit> volume = new Quantity<>(1.0,
                                VolumeUnit.LITRE);

                Quantity<VolumeUnit> converted = volume.convertTo(
                                VolumeUnit.MILLILITRE);

                assertEquals(
                                1000.0,
                                converted.getValue(),
                                0.01);
        }

        @Test
        public void testVolumeConversion_GallonToLitre() {

                Quantity<VolumeUnit> gallon = new Quantity<>(1.0,
                                VolumeUnit.GALLON);

                Quantity<VolumeUnit> converted = gallon.convertTo(
                                VolumeUnit.LITRE);

                assertEquals(
                                3.78541,
                                converted.getValue(),
                                0.01);
        }

        @Test
        public void testVolumeAddition() {

                Quantity<VolumeUnit> volume1 = new Quantity<>(1.0,
                                VolumeUnit.LITRE);

                Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0,
                                VolumeUnit.MILLILITRE);

                Quantity<VolumeUnit> result = volume1.add(volume2);

                assertEquals(
                                2.0,
                                result.getValue(),
                                0.01);
        }

        @Test
        public void testVolumeAddition_ExplicitTargetUnit() {

                Quantity<VolumeUnit> volume1 = new Quantity<>(1.0,
                                VolumeUnit.LITRE);

                Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0,
                                VolumeUnit.MILLILITRE);

                Quantity<VolumeUnit> result = volume1.add(
                                volume2,
                                VolumeUnit.MILLILITRE);

                assertEquals(
                                2000.0,
                                result.getValue(),
                                0.01);
        }

        @Test
        public void testVolumeVsLength_Incompatible() {

                Quantity<VolumeUnit> volume = new Quantity<>(1.0,
                                VolumeUnit.LITRE);

                Quantity<LengthUnit> length = new Quantity<>(1.0,
                                LengthUnit.FEET);

                assertFalse(volume.equals(length));
        }

        @Test
        public void testVolumeVsWeight_Incompatible() {

                Quantity<VolumeUnit> volume = new Quantity<>(1.0,
                                VolumeUnit.LITRE);

                Quantity<WeightUnit> weight = new Quantity<>(1.0,
                                WeightUnit.KILOGRAM);

                assertFalse(volume.equals(weight));
        }

        @Test
        public void testVolumeAdditionCommutativity() {

                Quantity<VolumeUnit> volume1 = new Quantity<>(1.0,
                                VolumeUnit.LITRE);

                Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0,
                                VolumeUnit.MILLILITRE);

                Quantity<VolumeUnit> result1 = volume1.add(volume2);

                Quantity<VolumeUnit> result2 = volume2.add(volume1);

                assertEquals(
                                result1.convertTo(
                                                VolumeUnit.LITRE)
                                                .getValue(),

                                result2.convertTo(
                                                VolumeUnit.LITRE)
                                                .getValue(),

                                0.01);
        }
}