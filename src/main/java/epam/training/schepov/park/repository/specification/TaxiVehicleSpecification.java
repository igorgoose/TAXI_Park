package epam.training.schepov.park.repository.specification;

import epam.training.schepov.park.taxi.TaxiVehicle;

public interface TaxiVehicleSpecification {
    boolean matches(TaxiVehicle taxiVehicle);
}
