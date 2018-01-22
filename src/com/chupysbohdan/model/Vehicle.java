package com.chupysbohdan.model;

/**
 * Created by User on 21.01.2018.
 */
public abstract class Vehicle {

    String model;

    public Vehicle(String model)
    {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
