package epam.training.schepov.park.specification.impl.sort.comparator;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.cargo.TaxiCargo;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxiVehicleComparatorByLoadAndPassengerTest {

    private static final TaxiVehicle vehicle1 = new TaxiCargo();
    private static final TaxiVehicle vehicle2 = new TaxiCargo();

    @Test
    public void LessLoadTest(){
        vehicle1.setLoadCapacity(1000);
        vehicle2.setLoadCapacity(1001);
        Assert.assertTrue(new TaxiVehicleComparatorByLoadAndPassenger().compare(vehicle1, vehicle2) < 0);
    }

    @Test
    public void GreaterLoadTest(){
        vehicle1.setLoadCapacity(1000);
        vehicle2.setLoadCapacity(999);
        Assert.assertTrue(new TaxiVehicleComparatorByLoadAndPassenger().compare(vehicle1, vehicle2) > 0);
    }

    @Test
    public void EqualLoadLessPassengerTest(){
        vehicle1.setLoadCapacity(1000);
        vehicle2.setLoadCapacity(1000);
        vehicle1.setPassengerCapacity(1);
        vehicle2.setPassengerCapacity(2);
        Assert.assertTrue(new TaxiVehicleComparatorByLoadAndPassenger().compare(vehicle1, vehicle2) < 0);
    }

    @Test
    public void EqualLoadGreaterPassengerTest(){
        vehicle1.setLoadCapacity(1000);
        vehicle2.setLoadCapacity(1000);
        vehicle1.setPassengerCapacity(3);
        vehicle2.setPassengerCapacity(2);
        Assert.assertTrue(new TaxiVehicleComparatorByLoadAndPassenger().compare(vehicle1, vehicle2) > 0);
    }

    @Test
    public void EqualLoadEqualPassengerTest(){
        vehicle1.setLoadCapacity(1000);
        vehicle2.setLoadCapacity(1000);
        vehicle1.setPassengerCapacity(2);
        vehicle2.setPassengerCapacity(2);
        assertEquals(0, new TaxiVehicleComparatorByLoadAndPassenger().compare(vehicle1, vehicle2));
    }
}