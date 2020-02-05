package epam.training.schepov.park.service;

import epam.training.schepov.park.exception.service.InvalidVehicleCapacityValueServiceException;
import epam.training.schepov.park.exception.service.NullObjectServiceException;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.math.BigDecimal;
import java.util.Set;

public interface TaxiService {
    void addVehicle(TaxiVehicle taxiVehicle) throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException;
    void removeVehicle(TaxiVehicle taxiVehicle) throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException;
    Set<TaxiVehicle> getVehiclesByLoadCapacity(int minCapacity, int maxCapacity) throws NullObjectServiceException;
    Set<TaxiVehicle> getVehiclesByPassengerCapacity(int minCapacity, int maxCapacity) throws NullObjectServiceException;
    Set<TaxiVehicle> getAllVehicles() throws NullObjectServiceException;
    BigDecimal getOverallValue();
    Set<TaxiVehicle> sortById() throws NullObjectServiceException;
    Set<TaxiVehicle> sortByLoadAndPassengerCapacity() throws NullObjectServiceException;
    Set<TaxiVehicle> sortByPassengerAndLoadCapacity() throws NullObjectServiceException;
    Set<TaxiVehicle> updateByID(TaxiVehicle newVehicle);
}
