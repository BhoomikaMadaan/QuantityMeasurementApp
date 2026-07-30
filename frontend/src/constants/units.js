// Mirrors the backend enums exactly (LengthUnit, WeightUnit, TemperatureUnit, VolumeUnit)
// and the "measurementType" strings the backend uses for history filtering
// (getMeasurementType() returns the enum class's simple name).

export const MEASUREMENT_TYPES = [
  { key: 'length', label: 'Length', image: '/images/length.png', backendType: 'LengthUnit' },
  { key: 'weight', label: 'Weight', image: '/images/weight.png', backendType: 'WeightUnit' },
  { key: 'temperature', label: 'Temperature', image: '/images/temp.png', backendType: 'TemperatureUnit' },
  { key: 'volume', label: 'Volume', image: '/images/volume.png', backendType: 'VolumeUnit' },
];

export const UNITS_BY_TYPE = {
  length: ['FEET', 'INCHES', 'YARDS', 'CENTIMETERS'],
  weight: ['KILOGRAM', 'GRAM', 'POUND'],
  temperature: ['CELSIUS', 'FAHRENHEIT', 'KELVIN'],
  volume: ['LITRE', 'MILLILITRE', 'GALLON'],
};

// Backend enum values for Temperature don't support arithmetic (COMPARE only
// makes sense via convert per Quantity.java's validateOperationSupport()).
export const TEMPERATURE_SUPPORTS_ARITHMETIC = false;

export const ACTIONS = [
  { key: 'compare', label: 'Comparison' },
  { key: 'convert', label: 'Conversion' },
  { key: 'add', label: 'Addition' },
  { key: 'subtract', label: 'Subtraction' },
  { key: 'divide', label: 'Division' },
];

// Operation strings exactly as stored by QuantityMeasurementServiceImpl
export const OPERATIONS = ['COMPARE', 'CONVERT', 'ADD', 'SUBTRACT', 'DIVIDE'];