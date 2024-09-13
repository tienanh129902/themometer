package org.example;

public class Threshold {
    private double value;
    private double tolerance;
    private boolean notifyOnlyOnDrop;

    public Threshold(double value, double tolerance, boolean notifyOnlyOnDrop) {
        this.value = value;
        this.tolerance = tolerance;
        this.notifyOnlyOnDrop = notifyOnlyOnDrop;
    }

    public double getValue() {
        return value;
    }

    public double getTolerance() {
        return tolerance;
    }

    public boolean shouldNotifyOnlyOnDrop() {
        return notifyOnlyOnDrop;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public void setNotifyOnlyOnDrop(boolean notifyOnlyOnDrop) {
        this.notifyOnlyOnDrop = notifyOnlyOnDrop;
    }
}
