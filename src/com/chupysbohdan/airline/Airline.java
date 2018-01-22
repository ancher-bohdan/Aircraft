package com.chupysbohdan.airline;

import com.chupysbohdan.model.*;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public abstract class Airline {

    protected Collection<Aircraft> aircrafts;

    public Airline(Comparator<Aircraft> comparator)
    {
        if(comparator == null)
        {
            aircrafts = new ConcurrentSkipListSet<>();
        }
        else
        {
            aircrafts = new ConcurrentSkipListSet<>(comparator);
        }
    }

    public void showAll()
    {
        aircrafts.stream().forEach(aircraft->System.out.println(aircraft));
    }

    public Stream<Aircraft> showWithinFuelConsumptionRange(int lowest, int highest)
    {
        return aircrafts.stream().filter(aircraft ->    (aircraft.getFuelConsumption() > lowest) &&
                                                        (aircraft.getFuelConsumption() < highest));
    }
    public int getTotalCapacitance()
    {
        int result = 0;
        for (Aircraft aircraft : aircrafts) {
            result += aircraft.getCapacitance();
        }
        return result;
    }

    public int getTotalCarryingCapacity()
    {
        int result = 0;
        for (Aircraft aircraft : aircrafts) {
            result += aircraft.getCarryingCapacitance();
        }
        return result;
    }

    protected String generateName()
    {
        Random random = new Random();
        return String.format("%c%c-%d", (char)random.nextInt(25) + 65,
                (char)random.nextInt(25) + 65, random.nextInt(899)+100);
    }

    protected void generateRandomPlanes()
    {
        Random random = new Random(20);
        for(int i = 0; i < 10; i++)
        {
            aircrafts.add(new Charter(generateName(),
                    random.nextInt(1000) + 100,
                    random.nextInt(1000) + 100,
                    random.nextInt(10000),
                    random.nextInt(256) + 100,
                    Comfort.values()[random.nextInt(3)]));

            aircrafts.add(new Jet(generateName(),
                    random.nextInt(1000) + 100,
                    random.nextInt(1000) + 100,
                    random.nextInt(10000),
                    random.nextInt(256) + 100,
                    random.nextInt(0xFFFFFFF)));

            aircrafts.add(new Airbus(generateName(),
                    random.nextInt(1000) + 100,
                    random.nextInt(1000) + 100,
                    random.nextInt(10000),
                    random.nextInt(256) + 100));
        }
    }
}
