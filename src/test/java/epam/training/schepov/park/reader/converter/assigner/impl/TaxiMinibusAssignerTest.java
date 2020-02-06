package epam.training.schepov.park.reader.converter.assigner.impl;

import epam.training.schepov.park.entity.auto.TaxiAuto;
import epam.training.schepov.park.entity.minibus.RideRegion;
import epam.training.schepov.park.entity.minibus.TaxiMinibus;
import epam.training.schepov.park.exception.converter.ConverterException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxiMinibusAssignerTest {
    @Test(expected = ConverterException.class)
    public void WrongTypeVehicleTest() throws ConverterException {
        TaxiMinibusAssigner.INSTANCE.assign(new TaxiAuto(), "INTERNATIONAL");
    }

    @Test(expected = ConverterException.class)
    public void NullVehicleTest() throws ConverterException {
        TaxiMinibusAssigner.INSTANCE.assign(null, "INTERNATIONAL");
    }

    @Test(expected = ConverterException.class)
    public void NullStringParameterTest() throws ConverterException {
        TaxiMinibusAssigner.INSTANCE.assign(new TaxiMinibus(), null);
    }

    @Test(expected = ConverterException.class)
    public void InvalidRideRegionParameterTest() throws ConverterException {
        TaxiMinibusAssigner.INSTANCE.assign(new TaxiMinibus(), "AAAAA");
    }

    @Test
    public void PositiveTest() throws ConverterException {
        TaxiMinibus vehicle = new TaxiMinibus();
        TaxiMinibusAssigner.INSTANCE.assign(vehicle, "INTERNATIONAL");
        Assert.assertEquals(vehicle.getRideRegion(), RideRegion.INTERNATIONAL);
    }

}