package epam.training.schepov.park.service;

import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.taxi.TaxiVehicle;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public interface TaxiService {
    void addVehicle(TaxiVehicle taxiVehicle);
    void removeVehicle(TaxiVehicle taxiVehicle);
    List<TaxiVehicle> getVehicles(TaxiVehicleSpecification specification);
    BigDecimal getOverallValue();
    List<TaxiVehicle> sort(Comparator<TaxiVehicle> comparator);
}
