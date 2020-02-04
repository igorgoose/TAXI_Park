package epam.training.schepov.park.service;

import epam.training.schepov.park.exception.service.InvalidVehicleCapacityValueServiceException;
import epam.training.schepov.park.exception.service.NullObjectServiceException;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.taxi.TaxiVehicle;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public interface TaxiService {
    void addVehicle(TaxiVehicle taxiVehicle) throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException;
    void removeVehicle(TaxiVehicle taxiVehicle) throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException;
    List<TaxiVehicle> getVehicles(TaxiVehicleSpecification specification) throws NullObjectServiceException;
    BigDecimal getOverallValue();
    List<TaxiVehicle> sort(Comparator<TaxiVehicle> comparator);
}
