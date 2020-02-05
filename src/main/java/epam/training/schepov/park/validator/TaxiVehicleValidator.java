package epam.training.schepov.park.validator;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.exception.validator.InvalidVehicleCapacityValueValidatorException;
import epam.training.schepov.park.exception.validator.NullObjectTaxiVehicleValidatorException;

public class TaxiVehicleValidator {

    public static void validate(TaxiVehicle taxiVehicle)
        throws NullObjectTaxiVehicleValidatorException,
        InvalidVehicleCapacityValueValidatorException {
        if(taxiVehicle == null){
            throw new NullObjectTaxiVehicleValidatorException("Null taxiVehicle passed!");
        }
        int passengerCapacity = taxiVehicle.getPassengerCapacity();
        int loadCapacity = taxiVehicle.getLoadCapacity();
        if(loadCapacity > taxiVehicle.getMaxLoadCapacity() ||
                loadCapacity < taxiVehicle.getMinLoadCapacity() ||
                passengerCapacity > taxiVehicle.getMaxPassengerCapacity() ||
                passengerCapacity < taxiVehicle.getMinPassengerCapacity()){
            throw new InvalidVehicleCapacityValueValidatorException("Invalid capacity value!");
        }
    }


}
