package epam.training.schepov.park.repository.specification.impl;

import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.taxi.TaxiVehicle;

public class TaxiVehicleSpecificationPassengerCapacity implements TaxiVehicleSpecification {

    private int minPassengerCapacity;
    private int maxPassengerCapacity;

    public TaxiVehicleSpecificationPassengerCapacity(int passengerCapacity){
        this.minPassengerCapacity = passengerCapacity;
        this.maxPassengerCapacity = passengerCapacity;
    }

    public TaxiVehicleSpecificationPassengerCapacity(int minPassengerCapacity, int maxPassengerCapacity){
        this.maxPassengerCapacity = maxPassengerCapacity;
        this.minPassengerCapacity = minPassengerCapacity;
    }

    @Override
    public boolean matches(TaxiVehicle taxiVehicle) {
        int passengerCapacity = taxiVehicle.getPassengerCapacity();
        return minPassengerCapacity <= passengerCapacity && maxPassengerCapacity >= passengerCapacity;
    }
}
