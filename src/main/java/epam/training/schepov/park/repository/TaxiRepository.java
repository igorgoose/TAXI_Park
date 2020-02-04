package epam.training.schepov.park.repository;

import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.List;

public interface TaxiRepository {
    void add(TaxiVehicle taxiVehicle);
    void remove(TaxiVehicle taxiVehicle);
    List<TaxiVehicle> get(TaxiVehicleSpecification specification);
}
