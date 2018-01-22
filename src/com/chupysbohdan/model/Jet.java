package com.chupysbohdan.model;


public class Jet extends Aircraft {

    int topSpeed;

    public Jet(String model, int capacitance, int totalCapacitance, int flyingRange, int fuelConsumption, int topSpeed) {
        super(model, capacitance, totalCapacitance, flyingRange, fuelConsumption);
        this.topSpeed = topSpeed;
    }

    @Override
    public String toString() {
        return super.toString() +
                "; top speed " + this.topSpeed + " ml/hour";
    }
}
