package epam.training.schepov.park.validator;

import epam.training.schepov.park.exception.service.InvalidVehicleCapacityValueServiceException;
import epam.training.schepov.park.exception.service.NullObjectServiceException;
import epam.training.schepov.park.entity.TaxiVehicle;

public class TaxiVehicleValidator {

    public static void validate(TaxiVehicle taxiVehicle) throws NullObjectServiceException, InvalidVehicleCapacityValueServiceException {
        if(taxiVehicle == null){
            //todo log
            throw new NullObjectServiceException("Null taxiVehicle passed!");
        }
        int passengerCapacity = taxiVehicle.getPassengerCapacity();
        int loadCapacity = taxiVehicle.getLoadCapacity();
        if(loadCapacity > taxiVehicle.getMaxLoadCapacity() ||
                loadCapacity < taxiVehicle.getMinLoadCapacity() ||
                passengerCapacity > taxiVehicle.getMaxPassengerCapacity() ||
                passengerCapacity < taxiVehicle.getMinPassengerCapacity()){
            //todo log
            throw new InvalidVehicleCapacityValueServiceException("Invalid capacity value!");
        }
    }


}
