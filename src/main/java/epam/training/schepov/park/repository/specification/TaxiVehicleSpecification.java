package epam.training.schepov.park.repository.specification;

import epam.training.schepov.park.entity.TaxiVehicle;

public interface TaxiVehicleSpecification {
    boolean matches(TaxiVehicle taxiVehicle);
}
