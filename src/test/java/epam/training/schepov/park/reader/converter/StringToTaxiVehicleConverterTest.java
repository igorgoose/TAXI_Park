package epam.training.schepov.park.reader.converter;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.auto.LuxuryClass;
import epam.training.schepov.park.entity.auto.TaxiAuto;
import epam.training.schepov.park.entity.brand.TaxiBrand;
import epam.training.schepov.park.exception.converter.ConverterException;
import epam.training.schepov.park.exception.validator.InvalidVehicleCapacityValueValidatorException;
import epam.training.schepov.park.exception.validator.NullObjectTaxiVehicleValidatorException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class StringToTaxiVehicleConverterTest {
    private static final String POSITIVE_STRING = "AUTO 8700.53 120 4 BMW BUSINESS";
    private static final String INVALID_PRICE_STRING = "AUTO INVALID 120 4 BMW BUSINESS";
    private static final String INVALID_LOAD_CAPACITY_STRING = "AUTO 8700.53 INVALID 4 BMW BUSINESS";
    private static final String INVALID_PASSENGER_CAPACITY_STRING = "AUTO 8700.53 120 INVALID BMW BUSINESS";
    private static final String INVALID_BRAND_STRING = "AUTO 8700.53 120 4 INVALID BUSINESS";
    private static final String INVALID_DEPENDENT_PARAMETER_STRING = "AUTO 8700.53 120 4 BMW INVALID";
    private static final String WRONG_PASSENGER_CAPACITY_PARAMETER_STRING = "AUTO 4700.53 120 8 BMW ECO";
    private static final String WRONG_LOAD_CAPACITY_PARAMETER_STRING = "AUTO 4700.53 800 4 BMW ECO";

    private static final String NULL_STRING = null;

    @Test
    public void PositiveTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException, ConverterException {
        TaxiVehicle taxiVehicle = StringToTaxiVehicleConverter.INSTANCE.convert(POSITIVE_STRING);
        Assert.assertEquals(taxiVehicle.getLoadCapacity(), 120);
        Assert.assertEquals(taxiVehicle.getPassengerCapacity(), 4);
        Assert.assertEquals(taxiVehicle.getPrice(), new BigDecimal("8700.53"));
        Assert.assertEquals(taxiVehicle.getBrand(), TaxiBrand.BMW);
        Assert.assertEquals(((TaxiAuto)taxiVehicle).getLuxuryClass(), LuxuryClass.BUSINESS);
    }

    @Test(expected = ConverterException.class)
    public void InvalidPriceTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException, ConverterException {
        StringToTaxiVehicleConverter.INSTANCE.convert(INVALID_PRICE_STRING);
    }

    @Test(expected = ConverterException.class)
    public void InvalidLoadCapacityTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException, ConverterException {
        StringToTaxiVehicleConverter.INSTANCE.convert(INVALID_LOAD_CAPACITY_STRING);
    }

    @Test(expected = ConverterException.class)
    public void InvalidPassengerCapacityTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException, ConverterException {
        StringToTaxiVehicleConverter.INSTANCE.convert(INVALID_PASSENGER_CAPACITY_STRING);
    }

    @Test(expected = ConverterException.class)
    public void InvalidBrandTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException, ConverterException {
        StringToTaxiVehicleConverter.INSTANCE.convert(INVALID_BRAND_STRING);
    }

    @Test(expected = ConverterException.class)
    public void InvalidDependentParameterTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException, ConverterException {
        StringToTaxiVehicleConverter.INSTANCE.convert(INVALID_DEPENDENT_PARAMETER_STRING);
    }

    @Test(expected = ConverterException.class)
    public void NullStringTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException, ConverterException {
        StringToTaxiVehicleConverter.INSTANCE.convert(INVALID_DEPENDENT_PARAMETER_STRING);
    }

    @Test(expected = InvalidVehicleCapacityValueValidatorException.class)
    public void WrongPassengerCapacityParameterTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException, ConverterException {
        StringToTaxiVehicleConverter.INSTANCE.convert(WRONG_PASSENGER_CAPACITY_PARAMETER_STRING);
    }

    @Test(expected = InvalidVehicleCapacityValueValidatorException.class)
    public void WrongLoadCapacityParameterTest() throws InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException, ConverterException {
        StringToTaxiVehicleConverter.INSTANCE.convert(WRONG_LOAD_CAPACITY_PARAMETER_STRING);
    }
}