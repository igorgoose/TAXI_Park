package epam.training.schepov.park.repository;

import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.taxi.TaxiVehicle;

public interface TaxiRepository {
    void add(TaxiVehicle taxiVehicle);
    void remove(TaxiVehicle taxiVehicle);
    void get(TaxiVehicleSpecification specification);
}
