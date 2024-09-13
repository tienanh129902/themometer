package org.example;

public class Subscriber {
    private String name;
    private Threshold threshold;
    private boolean wasNotified = false;

    public Subscriber(String name, Threshold threshold) {
        this.name = name;
        this.threshold = threshold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Threshold getThreshold() {
        return threshold;
    }

    public void setThreshold(Threshold threshold) {
        this.threshold = threshold;
    }

    public boolean isWasNotified() {
        return wasNotified;
    }

    public void setWasNotified(boolean wasNotified) {
        this.wasNotified = wasNotified;
    }

    public void checkThreshold(double previousTemperature, double currentTemperature) {
        boolean inRange = Math.abs(currentTemperature - threshold.getValue()) <= threshold.getTolerance();
        boolean directionSatisfied = true;
        if (threshold.shouldNotifyOnlyOnDrop()) {
            directionSatisfied = previousTemperature > threshold.getValue() && currentTemperature <= threshold.getValue();
        }
        if (inRange && directionSatisfied && !wasNotified) {
            double tempC = threshold.getValue();
            System.out.println("Subscriber " + name + " notified: Temperature reached " + tempC + " C / " + Utils.convertCelsiusToFahrenheit(tempC) + " F");
            wasNotified = true;
        }
        if (!inRange) {
            wasNotified = false;
        }
    }
}
