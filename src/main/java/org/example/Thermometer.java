package org.example;

import java.util.ArrayList;
import java.util.List;

public class Thermometer {
    private double currentTemperatureCelsius;
    private List<Subscriber> subscribers;

    public Thermometer() {
        this.subscribers = new ArrayList<>();
    }

    public void setCurrentTemperatureCelsius(double currentTemperatureCelsius) {
        this.currentTemperatureCelsius = currentTemperatureCelsius;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void updateTemperature(double newTemperatureCelsius) {
        double previousTemperature = this.currentTemperatureCelsius;
        this.currentTemperatureCelsius = newTemperatureCelsius;
        for (Subscriber subscriber : subscribers) {
            subscriber.checkThreshold(previousTemperature, currentTemperatureCelsius);
        }
    }
}
