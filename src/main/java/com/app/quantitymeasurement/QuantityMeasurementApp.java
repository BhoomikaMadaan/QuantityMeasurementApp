package com.app.quantitymeasurement;
import com.app.quantitymeasurement.controller.QuantityMeasurementController;
import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import com.app.quantitymeasurement.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {
	
	private static final IQuantityMeasurementService service =
	        new QuantityMeasurementServiceImpl(
	                QuantityMeasurementCacheRepository.getInstance());

	private static final QuantityMeasurementController controller =
	        new QuantityMeasurementController(service);

        public static void main(String[] args) {

                System.out.println(
                                "===== UC12  =====\n");

                demonstrateLengthOperations();

                demonstrateWeightOperations();

                demonstrateVolumeOperations();

                demonstrateSubtractionOperations();

                demonstrateDivisionOperations();
                demonstrateTemperatureOperations();

                demonstrateCrossCategorySafety();
//
//                System.out.println(TemperatureUnit.CELSIUS.getClass());
//                System.out.println(TemperatureUnit.FAHRENHEIT.getClass());
//                System.out.println(TemperatureUnit.KELVIN.getClass());

//                System.out.println(
//                                TemperatureUnit.CELSIUS.convertToBaseUnit(0));
//
//                System.out.println(
//                                TemperatureUnit.FAHRENHEIT.convertToBaseUnit(32));
//
//                System.out.println(
//                                TemperatureUnit.KELVIN.convertToBaseUnit(273.15));
        }

        /**
         * Length Demonstration
         */
        private static void demonstrateLengthOperations() {

                System.out.println(
                                "----- Length Operations -----");

                QuantityDTO<LengthUnit> length1 =
                        new QuantityDTO<>(
                                1.0,
                                LengthUnit.FEET);

                QuantityDTO<LengthUnit> length2 =
                        new QuantityDTO<>(
                                12.0,
                                LengthUnit.INCHES);
                System.out.println(
                                "Length 1: " + length1);

                System.out.println(
                                "Length 2: " + length2);

                System.out.println(
                                "\nEquality Check:");

                System.out.println(
                        controller.performComparison(
                                length1,
                                length2));

                System.out.println(
                                "\nAddition:");

                Quantity<LengthUnit> result =
                        controller.performAddition(
                                length1,
                                length2);
                System.out.println(result);

                System.out.println(
                                "\nAddition in INCHES:");

                Quantity<LengthUnit> inchResult =
                        controller.performAddition(
                                length1,
                                length2,
                                LengthUnit.INCHES);

                System.out.println(inchResult);

                
                

                System.out.println(
                                "\nConvert FEET to YARDS:");

                System.out.println(
                        controller.performConversion(
                                length1,
                                LengthUnit.YARDS));

                System.out.println();
        }

        /**
         * Weight Demonstration
         */
        private static void demonstrateWeightOperations() {

                System.out.println(
                                "----- Weight Operations -----");

                QuantityDTO<WeightUnit> weight1 =
                        new QuantityDTO<>(
                                1.0,
                                WeightUnit.KILOGRAM);

                QuantityDTO<WeightUnit> weight2 =
                        new QuantityDTO<>(
                                1000.0,
                                WeightUnit.GRAM);

                System.out.println(
                                "Weight 1: " + weight1);

                System.out.println(
                                "Weight 2: " + weight2);

                System.out.println(
                        "\nEquality Check:");

        System.out.println(
                controller.performComparison(
                        weight1,
                        weight2));

                System.out.println(
                                "\nAddition:");

                Quantity<WeightUnit> result =controller.performAddition(
                        weight1,
                        weight2);
                
                controller.performAddition(
                        weight1,
                        weight2,
                        WeightUnit.GRAM);
                System.out.println(result);


                

                System.out.println(
                        "\nAddition in GRAM:");

        Quantity<WeightUnit> gramResult =
                controller.performAddition(
                        weight1,
                        weight2,
                        WeightUnit.GRAM);

        System.out.println(gramResult);
                System.out.println(
                                "\nConvert KG to POUND:");

                System.out.println(controller.performConversion(
                        weight1,
                        WeightUnit.POUND));
                System.out.println();
        }

        /**
         * Volume Demonstration
         */
        private static void demonstrateVolumeOperations() {

                System.out.println(
                                "----- Volume Operations -----");

                QuantityDTO<VolumeUnit> volume1 =
                        new QuantityDTO<>(
                                1.0,
                                VolumeUnit.LITRE);

                QuantityDTO<VolumeUnit> volume2 =
                        new QuantityDTO<>(
                                1000.0,
                                VolumeUnit.MILLILITRE);

                QuantityDTO<VolumeUnit> volume3 =
                        new QuantityDTO<>(
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
                        controller.performComparison(
                                volume1,
                                volume2));

                System.out.println(
                                "\nAddition:");

                Quantity<VolumeUnit> result =
                        controller.performAddition(
                                volume1,
                                volume2);
                
                controller.performAddition(
                        volume1,
                        volume2,
                        VolumeUnit.MILLILITRE);
                System.out.println(result);

                System.out.println(
                        "\nAddition in MILLILITRE:");

                Quantity<VolumeUnit> mlResult =
                        controller.performAddition(
                                volume1,
                                volume2,
                                VolumeUnit.MILLILITRE);

                System.out.println(mlResult);

                System.out.println(
                                "\nConvert GALLON to LITRE:");

                System.out.println(
                        controller.performConversion(
                                volume3,
                                VolumeUnit.LITRE));

                System.out.println();
        }

        /**
         * UC-12 Subtraction Demonstration
         */
        private static void demonstrateSubtractionOperations() {

            System.out.println(
                    "----- Subtraction Operations -----");

            QuantityDTO<LengthUnit> length1 =
                    new QuantityDTO<>(
                            10.0,
                            LengthUnit.FEET);

            QuantityDTO<LengthUnit> length2 =
                    new QuantityDTO<>(
                            6.0,
                            LengthUnit.INCHES);

            System.out.println(
                    "10 FEET - 6 INCHES = "
                            + controller.performSubtraction(
                                    length1,
                                    length2));

            System.out.println(
                    "10 FEET - 6 INCHES (INCHES) = "
                            + controller.performSubtraction(
                                    length1,
                                    length2,
                                    LengthUnit.INCHES));

            System.out.println();
        }

        /**
         * Division Demonstration
         */
        private static void demonstrateDivisionOperations() {

            System.out.println(
                    "----- Division Operations -----");

            QuantityDTO<LengthUnit> length1 =
                    new QuantityDTO<>(
                            24.0,
                            LengthUnit.INCHES);

            QuantityDTO<LengthUnit> length2 =
                    new QuantityDTO<>(
                            2.0,
                            LengthUnit.FEET);

            System.out.println(
                    "24 INCHES / 2 FEET = "
                            + controller.performDivision(
                                    length1,
                                    length2));

            QuantityDTO<WeightUnit> weight1 =
                    new QuantityDTO<>(
                            10.0,
                            WeightUnit.KILOGRAM);

            QuantityDTO<WeightUnit> weight2 =
                    new QuantityDTO<>(
                            5.0,
                            WeightUnit.KILOGRAM);

            System.out.println(
                    "10 KG / 5 KG = "
                            + controller.performDivision(
                                    weight1,
                                    weight2));

            System.out.println();
        }

        /**
         * UC-14Temperature Demonstration
         */
        private static void demonstrateTemperatureOperations() {

                System.out.println(
                                "----- Temperature Operations -----");

                QuantityDTO<TemperatureUnit> celsius =
                        new QuantityDTO<>(
                                0,
                                TemperatureUnit.CELSIUS);

                QuantityDTO<TemperatureUnit> fahrenheit =
                        new QuantityDTO<>(
                                32,
                                TemperatureUnit.FAHRENHEIT);

                QuantityDTO<TemperatureUnit> kelvin =
                        new QuantityDTO<>(
                                273.15,
                                TemperatureUnit.KELVIN);

                System.out.println(
                                "0°C equals 32°F ?");

                System.out.println(
                        controller.performComparison(
                                celsius,
                                fahrenheit));

                System.out.println(
                                "0°C equals 273.15K ?");

                System.out.println(
                        controller.performComparison(
                                celsius,
                                kelvin));

                System.out.println(
                                "\nConvert 100°C to Fahrenheit:");

                QuantityDTO<TemperatureUnit> boilingPoint =
                        new QuantityDTO<>(
                                100,
                                TemperatureUnit.CELSIUS);

                System.out.println(
                        controller.performConversion(
                                boilingPoint,
                                TemperatureUnit.FAHRENHEIT));
                System.out.println(
                                "\nUnsupported Operation Demo:");

                try {

                    controller.performAddition(
                            celsius,
                            fahrenheit);

                }
                catch (Exception e) {

                    System.out.println(e.getMessage());

                }
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