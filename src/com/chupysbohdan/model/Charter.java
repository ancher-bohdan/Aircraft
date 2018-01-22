package com.chupysbohdan.model;

/**
 * Created by User on 21.01.2018.
 */
public class Charter extends Aircraft {

    Comfort comfort;

    public Charter(String model, int capacitance, int totalCapacitance, int flyingRange, int fuelConsumption, Comfort comfort) {
        super(model, capacitance, totalCapacitance, flyingRange, fuelConsumption);
        this.comfort = comfort;
    }

    public Comfort getComfort() {
        return comfort;
    }

    public void setComfort(Comfort comfort) {
        this.comfort = comfort;
    }

    @Override
    public String toString() {
        return super.toString() +
                "; comfort level " + this.comfort.name();
    }
}
