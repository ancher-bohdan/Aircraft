package com.chupysbohdan.model;

import java.util.UUID;

/**
 * Created by User on 21.01.2018.
 */
public abstract class Aircraft extends Vehicle implements Comparable<Aircraft> {

    UUID id;
    int capacitance;
    int carryingCapacitance;
    int flyingRange;
    int fuelConsumption;

    public Aircraft(String model, int capacitance, int carryingCapacitance,int flyingRange, int fuelConsumption) {
        super(model);
        this.capacitance = capacitance;
        this.flyingRange = flyingRange;
        this.fuelConsumption = fuelConsumption;
        this.carryingCapacitance = carryingCapacitance;
        this.id = UUID.randomUUID();
    }

    public int getFlyingRange() {
        return flyingRange;
    }

    public int getCarryingCapacitance() {
        return carryingCapacitance;
    }

    public int getCapacitance() {
        return capacitance;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int compareTo(Aircraft aircraft)
    {
        if(this.equals(aircraft))
        {
            return 0;
        }
        if(this.getFlyingRange() == aircraft.getFlyingRange())
        {
            return id.compareTo(aircraft.id);
        }

        return this.flyingRange > aircraft.flyingRange ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aircraft aircraft = (Aircraft) o;

        if (capacitance != aircraft.capacitance) return false;
        if (carryingCapacitance != aircraft.carryingCapacitance) return false;
        if (flyingRange != aircraft.flyingRange) return false;
        if (fuelConsumption != aircraft.fuelConsumption) return false;
        return id != null ? id.equals(aircraft.id) : aircraft.id == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + capacitance;
        result = 31 * result + carryingCapacitance;
        result = 31 * result + flyingRange;
        result = 31 * result + fuelConsumption;
        return result;
    }

    @Override
    public String toString() {
        return id +
                " Aircraft " + this.getModel() +
                ", capacitance=" + capacitance +
                ", carryingCapacitance=" + carryingCapacitance +
                ", flyingRange=" + flyingRange +
                ", fuelConsumption=" + fuelConsumption + " liters per hour";
    }
}
