package epam.training.schepov.park.repository.specification;

import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.Set;
import java.util.TreeSet;


public interface TaxiVehicleSpecification {
    Set<TaxiVehicle> query();
}
