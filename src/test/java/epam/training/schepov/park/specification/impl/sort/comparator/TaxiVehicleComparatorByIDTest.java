package epam.training.schepov.park.specification.impl.sort.comparator;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.auto.TaxiAuto;
import epam.training.schepov.park.entity.cargo.TaxiCargo;
import epam.training.schepov.park.entity.minibus.TaxiMinibus;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxiVehicleComparatorByIDTest {

    private final TaxiVehicle vehicle1 = new TaxiCargo();
    private final TaxiVehicle vehicle2 = new TaxiMinibus();
    private static final int DEFAULT_ID = 1;

    @Test
    public void LessIDTest(){
        Assert.assertTrue(new TaxiVehicleComparatorByID().compare(vehicle1, vehicle2) < 0);
    }

    @Test
    public void GreaterIDTest(){
        Assert.assertTrue(new TaxiVehicleComparatorByID().compare(vehicle2, vehicle1) > 0);
    }

    @Test
    public void EqualIdTest(){
        TaxiVehicle taxiVehicle1 = new TaxiAuto(){
            @Override
            public int getId() {
                return DEFAULT_ID;
            }
        };
        TaxiVehicle taxiVehicle2 = new TaxiMinibus(){
            @Override
            public int getId() {
                return DEFAULT_ID;
            }
        };
        assertEquals(0, new TaxiVehicleComparatorByID().compare(taxiVehicle1, taxiVehicle2));
    }
}