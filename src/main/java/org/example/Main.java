package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer();
        Threshold freezingThreshold = new Threshold(0.0, 0.5, true);
        Threshold boilingThreshold = new Threshold(100.0, 1.0, false);

        // Create subscribers with different thresholds
        Subscriber freezingSubscriber = new Subscriber("Freezing Alert", freezingThreshold);
        Subscriber boilingSubscriber = new Subscriber("Boiling Alert", boilingThreshold);

        // Add subscribers to the thermometer
        thermometer.addSubscriber(freezingSubscriber);
        thermometer.addSubscriber(boilingSubscriber);

        // Test Case 1: Celsius readings
        System.out.println("Test Case 1: Celsius readings");
        runTest(thermometer, "/test_case_1.txt");

        // Test Case 2: Fahrenheit readings
        System.out.println("\nTest Case 2: Fahrenheit readings");
        runTest(thermometer, "/test_case_2.txt");

        // Test Case 3: Temperature fluctuations around threshold
        System.out.println("\nTest Case 3: Fluctuations around threshold");
        runTest(thermometer, "/test_case_3.txt");

        // Test Case 4: Falling temperature threshold trigger
        System.out.println("\nTest Case 4: Falling temperature threshold");
        runTest(thermometer, "/test_case_4.txt");

        // Test Case 5: Rising temperature threshold trigger
        System.out.println("\nTest Case 5: Rising temperature threshold");
        runTest(thermometer, "/test_case_5.txt");

        // Test Case 6: Boiling point threshold in Fahrenheit
        System.out.println("\nTest Case 6: Boiling point threshold in Fahrenheit");
        runTest(thermometer, "/test_case_6.txt");

        // Test Case 7: Mixed Celsius and Fahrenheit readings
        System.out.println("\nTest Case 7: Mixed Celsius and Fahrenheit readings");
        runTest(thermometer, "/test_case_7.txt");
    }

    private static void runTest(Thermometer thermometer, String fileName) {
        List<TemperatureReading> temperatureReadings = Utils.readTemperaturesFromFile(fileName);

        // Simulate temperature changes and notify subscribers if necessary
        for (TemperatureReading reading : temperatureReadings) {
            double tempInCelsius = reading.isCelsius ? reading.value : Utils.convertFahrenheitToCelsius(reading.value);
            System.out.println("Temperature update: " + tempInCelsius + " C / " + Utils.convertCelsiusToFahrenheit(tempInCelsius) + " F");
            thermometer.updateTemperature(tempInCelsius);
        }
    }
}