package epam.training.schepov.park.reader.converter.assigner.impl;

import epam.training.schepov.park.entity.auto.LuxuryClass;
import epam.training.schepov.park.entity.auto.TaxiAuto;
import epam.training.schepov.park.entity.cargo.TaxiCargo;
import epam.training.schepov.park.exception.converter.ConverterException;
import org.junit.Assert;
import org.junit.Test;

public class TaxiAutoAssignerTest {

    @Test(expected = ConverterException.class)
    public void WrongTypeVehicleTest() throws ConverterException {
        TaxiAutoAssigner.INSTANCE.assign(new TaxiCargo(), "AAA");
    }

    @Test(expected = ConverterException.class)
    public void NullVehicleTest() throws ConverterException {
        TaxiAutoAssigner.INSTANCE.assign(null, "AAA");
    }

    @Test(expected = ConverterException.class)
    public void NullStringParameterTest() throws ConverterException {
        TaxiAutoAssigner.INSTANCE.assign(new TaxiAuto(), null);
    }

    @Test(expected = ConverterException.class)
    public void InvalidLuxuryClassParameterTest() throws ConverterException {
        TaxiAutoAssigner.INSTANCE.assign(new TaxiAuto(), "AAAAA");
    }

    @Test
    public void PositiveTest() throws ConverterException {
        TaxiAuto vehicle = new TaxiAuto();
        TaxiAutoAssigner.INSTANCE.assign(vehicle, "ELITE");
        Assert.assertEquals(vehicle.getLuxuryClass(), LuxuryClass.ELITE);
    }
}