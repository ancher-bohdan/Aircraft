package com.chupysbohdan.airline;

import com.chupysbohdan.model.Aircraft;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by User on 21.01.2018.
 */
public class Visair extends Airline {

    public Visair()
    {
        super(null);
        generateRandomPlanes();
    }

    public Visair(Comparator<Aircraft> comparator)
    {
        super(comparator);
        generateRandomPlanes();
    }
}
