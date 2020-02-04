package epam.training.schepov.park.repository.specification.impl;

import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.taxi.TaxiVehicle;

public class TaxiVehicleSpecificationAny implements TaxiVehicleSpecification {

    @Override
    public boolean matches(TaxiVehicle taxiVehicle) {
        return true;
    }
}
