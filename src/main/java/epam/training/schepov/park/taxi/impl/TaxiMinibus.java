package epam.training.schepov.park.taxi.impl;

import epam.training.schepov.park.taxi.TaxiVehicle;

public class TaxiMinibus extends TaxiVehicle {
    private static final int MIN_LOAD_CAPACITY = 0;
    private static final int MAX_LOAD_CAPACITY = 500;
    private static final int MIN_PASSENGER_CAPACITY = 7;
    private static final int MAX_PASSENGER_CAPACITY = 12;

    @Override
    public int getMinLoadCapacity() {
        return MIN_LOAD_CAPACITY;
    }

    @Override
    public int getMaxLoadCapacity() {
        return MAX_LOAD_CAPACITY;
    }

    @Override
    public int getMinPassengerCapacity() {
        return MIN_PASSENGER_CAPACITY;
    }

    @Override
    public int getMaxPassengerCapacity() {
        return MAX_PASSENGER_CAPACITY;
    }
}
