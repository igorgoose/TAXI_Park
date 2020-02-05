package epam.training.schepov.park.specification;

import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.Set;


public interface TaxiVehicleSpecification {
    Set<TaxiVehicle> query();
}
