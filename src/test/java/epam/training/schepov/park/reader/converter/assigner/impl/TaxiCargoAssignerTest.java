package epam.training.schepov.park.reader.converter.assigner.impl;

import epam.training.schepov.park.entity.auto.LuxuryClass;
import epam.training.schepov.park.entity.auto.TaxiAuto;
import epam.training.schepov.park.entity.cargo.BodyType;
import epam.training.schepov.park.entity.cargo.TaxiCargo;
import epam.training.schepov.park.exception.converter.ConverterException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxiCargoAssignerTest {
    @Test(expected = ConverterException.class)
    public void WrongTypeVehicleTest() throws ConverterException {
        TaxiCargoAssigner.INSTANCE.assign(new TaxiAuto(), "CLOSED");
    }

    @Test(expected = ConverterException.class)
    public void NullVehicleTest() throws ConverterException {
        TaxiCargoAssigner.INSTANCE.assign(null, "AAA");
    }

    @Test(expected = ConverterException.class)
    public void NullStringParameterTest() throws ConverterException {
        TaxiCargoAssigner.INSTANCE.assign(new TaxiCargo(), null);
    }

    @Test(expected = ConverterException.class)
    public void InvalidBodyTypeParameterTest() throws ConverterException {
        TaxiCargoAssigner.INSTANCE.assign(new TaxiCargo(), "AAAAA");
    }

    @Test
    public void PositiveTest() throws ConverterException {
        TaxiCargo vehicle = new TaxiCargo();
        TaxiCargoAssigner.INSTANCE.assign(vehicle, "CLOSED");
        Assert.assertEquals(vehicle.getBodyType(), BodyType.CLOSED);
    }
}