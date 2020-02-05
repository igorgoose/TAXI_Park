package epam.training.schepov.park.service;

import epam.training.schepov.park.exception.service.InvalidVehicleCapacityValueServiceException;
import epam.training.schepov.park.exception.service.NullObjectServiceException;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.math.BigDecimal;
import java.util.List;

public interface TaxiService {
    void addVehicle(TaxiVehicle taxiVehicle) throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException;
    void removeVehicle(TaxiVehicle taxiVehicle) throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException;
    List<TaxiVehicle> getVehiclesByLoadCapacity(int minCapacity, int maxCapacity) throws NullObjectServiceException;
    List<TaxiVehicle> getVehiclesByPassengerCapacity(int minCapacity, int maxCapacity) throws NullObjectServiceException;
    List<TaxiVehicle> getAllVehicles() throws NullObjectServiceException;
    BigDecimal getOverallValue();
    void sortById() throws NullObjectServiceException;
    void sortByLoadAndPassengerCapacityGreater() throws NullObjectServiceException;
    void sortByLoadAndPassengerCapacityLess() throws NullObjectServiceException;
}
