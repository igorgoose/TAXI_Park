package epam.training.schepov.park.validator;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.auto.TaxiAuto;
import epam.training.schepov.park.exception.validator.InvalidVehicleCapacityValueValidatorException;
import epam.training.schepov.park.exception.validator.NullObjectTaxiVehicleValidatorException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxiVehicleValidatorTest {

    private static final TaxiVehicle vehicle = new TaxiAuto();

    @Test(expected = NullObjectTaxiVehicleValidatorException.class)
    public void NullTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException {
        TaxiVehicleValidator.validate(null);
    }

    @Test(expected = InvalidVehicleCapacityValueValidatorException.class)
    public void LessThanMinLoadTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException {
        vehicle.setLoadCapacity(vehicle.getMinLoadCapacity() - 1);
        TaxiVehicleValidator.validate(vehicle);
    }

    @Test(expected = InvalidVehicleCapacityValueValidatorException.class)
    public void LessThanMinPassengerTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException {
        vehicle.setPassengerCapacity(vehicle.getMinPassengerCapacity() - 1);
        TaxiVehicleValidator.validate(vehicle);
    }

    @Test(expected = InvalidVehicleCapacityValueValidatorException.class)
    public void GreaterThanMaxLoadTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException {
        vehicle.setLoadCapacity(vehicle.getMaxLoadCapacity() + 1);
        TaxiVehicleValidator.validate(vehicle);
    }

    @Test(expected = InvalidVehicleCapacityValueValidatorException.class)
    public void GreaterThanMaxPassengerTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException {
        vehicle.setPassengerCapacity(vehicle.getMaxPassengerCapacity() + 1);
        TaxiVehicleValidator.validate(vehicle);
    }


}