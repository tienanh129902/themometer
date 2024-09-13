package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static double convertFahrenheitToCelsius(double tempF) {
        return (tempF - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double tempC) {
        return (tempC * 9 / 5) + 32;
    }

    public static List<TemperatureReading> readTemperaturesFromFile(String fileName) {
        List<TemperatureReading> temperatures = new ArrayList<>();
        try (InputStream inputStream = Thermometer.class.getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (parts.length == 2) {
                        double tempValue = Double.parseDouble(parts[0]);
                        String unit = parts[1];
                        boolean isCelsius = unit.equalsIgnoreCase("C");
                        temperatures.add(new TemperatureReading(tempValue, isCelsius));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("File not found: " + fileName);
        }
        return temperatures;
    }
}
