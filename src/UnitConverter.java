import java.util.Map;

public  class UnitConverter{
    static double value;

    public static double Converter(String category,String fromUnit, String toUnit,  Double value){



        return switch (category) {
            case "Length" ->  convertLength(fromUnit, toUnit, value);
            case "Temperature" -> convertTemperature(fromUnit, toUnit, value);
            case "Area" -> convertArea(fromUnit, toUnit, value);
            case "Volume" -> convertVolume(fromUnit, toUnit, value);
            case "Weight" -> convertWeight(fromUnit, toUnit, value);
            case "Data" -> convertData(fromUnit, toUnit, value);
            case "Speed" -> convertSpeed(fromUnit, toUnit, value);
            case "Time" -> convertTime(fromUnit, toUnit, value);
            case "Pressure" -> convertPressure(fromUnit, toUnit, value);
            case "Acceleration" -> ConvertAcceleration(fromUnit, toUnit, value);


            // Add conversion logic for other categories as needed
            default -> throw new UnsupportedOperationException("Conversion not supported for category: " + category);
        };
    }


    private static double convertLength(String fromUnit, String toUnit, double value) {
        // Define conversion factors for length units
        final Map<String, Double> LENGTH_CONVERSION_FACTORS = Map.ofEntries(
                Map.entry("meters", 1.0),
                Map.entry("centimeters", 1e-2),
                Map.entry("millimeters", 1e-3),
                Map.entry("kilometers", 1e3),
                Map.entry("inches", 2.54e-2),
                Map.entry("feet", 0.3048),
                Map.entry("miles",1609.344),
                Map.entry("yards", 0.9144),
                Map.entry("nautical miles", 1.852),
                Map.entry("micrometers", 1e-6),
                Map.entry("nanometers", 1e-9),
                Map.entry("angstroms", 1e-10)
        );

            // Check if units are valid
            if (!LENGTH_CONVERSION_FACTORS.containsKey(fromUnit) || !LENGTH_CONVERSION_FACTORS.containsKey(toUnit)) {
                throw new IllegalArgumentException("Unsupported length unit: " + fromUnit + " or " + toUnit);
            }

            // Perform conversion using conversion factors
            double conversionFactor = LENGTH_CONVERSION_FACTORS.get(fromUnit) / LENGTH_CONVERSION_FACTORS.get(toUnit);
            return value * conversionFactor;
        }


    private static double convertTemperature(String fromUnit, String toUnit, double value) {
        // Conversion logic for temperature units
        switch (fromUnit) {
            case "kelvin":
                if (toUnit.equals("celsius")) {
                    return value - 273.15;
                } else if (toUnit.equals("fahrenheit")) {
                    return (value - 273.15) * 9 / 5 + 32;
                } else if (toUnit.equals("kelvin")){
                    return value;
                }
            case "celsius":
                if (toUnit.equals("kelvin")) {
                    return value + 273.15;
                } else if (toUnit.equals("fahrenheit")) {
                    return value * 9 / 5 + 32;
                } else if (toUnit.equals("celsius")){
                    return value;
                }
            case "fahrenheit":
                if (toUnit.equals("kelvin")) {
                    return (value - 32) * 5 / 9 + 273.15;
                } else if (toUnit.equals("celsius")) {
                    return (value - 32) * 5 / 9;
                } else if (toUnit.equals("fahrenheit")){
                    return value;
                }


        }
        return 0;
    }


    private static double convertArea(String fromUnit, String toUnit, double value) {
        // Define conversion factors for area units
        final Map<String, Double> AREA_CONVERSION_FACTORS = Map.ofEntries(
                Map.entry("square meters", 1.0),
                Map.entry("square kilometers", 1e6),
                Map.entry("square centimeters", 1e-4),
                Map.entry("square millimeters", 1e-6),
                Map.entry("hectares", 1e4),
                Map.entry("acres", 4046.856),
                Map.entry("square feet", 0.09290304),
                Map.entry("square yards", 0.83612736)
        );

        // Perform conversion using conversion factors
        double conversionFactor = AREA_CONVERSION_FACTORS.get(fromUnit) / AREA_CONVERSION_FACTORS.get(toUnit);
        return value * conversionFactor;
    }


    private static double convertVolume(String fromUnit, String toUnit, double value) {
        // Define conversion factors for volume units
        final Map<String, Double> VOLUME_CONVERSION_FACTORS = Map.ofEntries(
                Map.entry("liters", 1.0),
                Map.entry("cubic meters", 1000.0),
                Map.entry("milliliters", 0.001),
                Map.entry("gallons", 3.78541), // US gallons
                Map.entry("cubic feet", 0.0283168),
                Map.entry("fluid ounces", 0.0295735)
        );






        // Perform conversion using conversion factors
        double conversionFactor = VOLUME_CONVERSION_FACTORS.get(fromUnit) / VOLUME_CONVERSION_FACTORS.get(toUnit);
        return value * conversionFactor;
    }

    private static double convertWeight(String fromUnit, String toUnit, double value) {
        // Define conversion factors for weight units
        final Map<String, Double> WEIGHT_CONVERSION_FACTORS = Map.ofEntries(
                Map.entry("grams", 1.0),
                Map.entry("kilograms", 1000.0),
                Map.entry("milligrams", 0.001),
                Map.entry("pounds", 453.592),
                Map.entry("ounces", 28.3495),
                Map.entry("tons", 907.185)
        );



        // Perform conversion using conversion factors
        double conversionFactor = WEIGHT_CONVERSION_FACTORS.get(fromUnit) / WEIGHT_CONVERSION_FACTORS.get(toUnit);
        return value * conversionFactor;
    }


    private static double convertData(String fromUnit, String toUnit, double value) {
        // Define conversion factors for data units (in binary bytes)
        final Map<String, Double> DATA_CONVERSION_FACTORS = Map.ofEntries(
                Map.entry("bytes", 1.0),
                Map.entry("kilobytes", 1024.0),
                Map.entry("megabytes", 1024.0 * 1024.0),
                Map.entry("gigabytes", 1024.0 * 1024.0 * 1024.0),
                Map.entry("terabytes", 1024.0 * 1024.0 * 1024.0 * 1024.0),
                Map.entry("petabytes", 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0),
                Map.entry("exabytes", 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0)
        );


        // Perform conversion using conversion factors
        double conversionFactor = DATA_CONVERSION_FACTORS.get(fromUnit) / DATA_CONVERSION_FACTORS.get(toUnit);
        return value * conversionFactor;
    }

    private static double convertSpeed(String fromUnit, String toUnit, double value) {
        // Define conversion factors for speed units
        final Map<String, Double> SPEED_CONVERSION_FACTORS = Map.ofEntries(
                Map.entry("meters per second", 1.0),
                Map.entry("kilometers per hour", 3.6),
                Map.entry("miles per hour", 2.23694),
                Map.entry("knots", 1.94384)
        );



        // Perform conversion using conversion factors
        double conversionFactor = SPEED_CONVERSION_FACTORS.get(fromUnit) / SPEED_CONVERSION_FACTORS.get(toUnit);
        return value * conversionFactor;
    }
    private static double convertTime(String fromUnit, String toUnit, double value) {
        // Define conversion factors for time units (seconds per unit)
        final Map<String, Double> TIME_CONVERSION_FACTORS = Map.ofEntries(
                Map.entry("seconds", 1.0),
                Map.entry("minutes", 60.0),
                Map.entry("hours", 3600.0),
                Map.entry("days", 86400.0),
                Map.entry("weeks", 604800.0), //
                Map.entry("months", 2592000.0), //
                Map.entry("years", 31536000.0) //
        );



        // Perform conversion using conversion factors
        double conversionFactor = TIME_CONVERSION_FACTORS.get(fromUnit) / TIME_CONVERSION_FACTORS.get(toUnit);
        return value * conversionFactor;
    }

    private static double convertPressure(String fromUnit, String toUnit, double value) {
        // Define conversion factors for pressure units
        final Map<String, Double> PRESSURE_CONVERSION_FACTORS = Map.ofEntries(
                Map.entry("pascals", 1.0),
                Map.entry("bars", 1e5),
                Map.entry("atmospheres", 1.01325e5),
                Map.entry("torr", 133.322),
                Map.entry("pounds per square inch", 6894.76)
        );


        // Perform conversion using conversion factors
        double conversionFactor = PRESSURE_CONVERSION_FACTORS.get(fromUnit) / PRESSURE_CONVERSION_FACTORS.get(toUnit);
        return value * conversionFactor;
    }

    private static double ConvertAcceleration(String fromUnit, String toUnit, double value) {
        // Define conversion factors for acceleration units
        final Map<String, Double> ACCELERATION_CONVERSION_FACTORS = Map.ofEntries(
                Map.entry("meters per second squared", 1.0),
                Map.entry("kilometers per hour per second", 0.277778), // Conversion factor from km/h to m/s and then to m/s^2
                Map.entry("g-force", 9.80665)
        );

        // Perform conversion using conversion factors
        double conversionFactor = ACCELERATION_CONVERSION_FACTORS.get(fromUnit) / ACCELERATION_CONVERSION_FACTORS.get(toUnit);
        return value * conversionFactor;
    }


}
