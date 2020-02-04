package epam.training.schepov.park.repository.specification.impl;

import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.taxi.TaxiVehicle;

public class TaxiVehicleSpecificationById implements TaxiVehicleSpecification {
    private int id;

    public TaxiVehicleSpecificationById(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean matches(TaxiVehicle taxiVehicle) {
        return taxiVehicle.getId() == id;
    }
}
