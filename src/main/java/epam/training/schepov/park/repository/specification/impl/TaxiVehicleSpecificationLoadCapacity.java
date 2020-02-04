package epam.training.schepov.park.repository.specification.impl;

import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;

public class TaxiVehicleSpecificationLoadCapacity implements TaxiVehicleSpecification {

    private int minLoadCapacity;
    private int maxLoadCapacity;

    public TaxiVehicleSpecificationLoadCapacity(int loadCapacity){
        this.minLoadCapacity = loadCapacity;
        this.maxLoadCapacity = loadCapacity;
    }

    public TaxiVehicleSpecificationLoadCapacity(int minLoadCapacity, int maxLoadCapacity){
        this.maxLoadCapacity = maxLoadCapacity;
        this.minLoadCapacity = minLoadCapacity;
    }

    @Override
    public boolean matches(TaxiVehicle taxiVehicle) {
        int loadCapacity = taxiVehicle.getLoadCapacity();
        return minLoadCapacity <= loadCapacity && maxLoadCapacity >= loadCapacity;
    }
}
