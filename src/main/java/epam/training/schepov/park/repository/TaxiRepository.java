package epam.training.schepov.park.repository;

import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.Collection;

public interface TaxiRepository {
    void add(TaxiVehicle taxiVehicle);
    void remove(TaxiVehicle taxiVehicle);
    Collection<TaxiVehicle> get(TaxiVehicleSpecification specification);
    Collection<TaxiVehicle> getAll();
}
