package epam.training.schepov.park.repository;


import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.Set;


public interface TaxiRepository {
    void add(TaxiVehicle taxiVehicle);
    void remove(TaxiVehicle taxiVehicle);
    void update(TaxiVehicle taxiVehicle);
    Set<TaxiVehicle> getAll();
    Set<TaxiVehicle> query(TaxiVehicleSpecification specification);
}
