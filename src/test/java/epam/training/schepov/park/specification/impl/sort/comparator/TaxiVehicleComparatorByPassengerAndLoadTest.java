package epam.training.schepov.park.specification.impl.sort.comparator;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.cargo.TaxiCargo;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxiVehicleComparatorByPassengerAndLoadTest {
    private static final TaxiVehicle vehicle1 = new TaxiCargo();
    private static final TaxiVehicle vehicle2 = new TaxiCargo();

    @Test
    public void LessPassengerTest(){
        vehicle1.setPassengerCapacity(2);
        vehicle2.setPassengerCapacity(3);
        Assert.assertTrue(new TaxiVehicleComparatorByPassengerAndLoad().compare(vehicle1, vehicle2) < 0);
    }

    @Test
    public void GreaterPassengerTest(){
        vehicle1.setPassengerCapacity(3);
        vehicle2.setPassengerCapacity(2);
        Assert.assertTrue(new TaxiVehicleComparatorByPassengerAndLoad().compare(vehicle1, vehicle2) > 0);
    }

    @Test
    public void EqualPassengerLessLoadTest(){
        vehicle1.setLoadCapacity(999);
        vehicle2.setLoadCapacity(1000);
        vehicle1.setPassengerCapacity(2);
        vehicle2.setPassengerCapacity(2);
        Assert.assertTrue(new TaxiVehicleComparatorByPassengerAndLoad().compare(vehicle1, vehicle2) < 0);
    }

    @Test
    public void EqualPassengerGreaterLoadTest(){
        vehicle1.setLoadCapacity(1001);
        vehicle2.setLoadCapacity(1000);
        vehicle1.setPassengerCapacity(2);
        vehicle2.setPassengerCapacity(2);
        Assert.assertTrue(new TaxiVehicleComparatorByPassengerAndLoad().compare(vehicle1, vehicle2) > 0);
    }

    @Test
    public void EqualLoadEqualPassengerTest(){
        vehicle1.setLoadCapacity(1000);
        vehicle2.setLoadCapacity(1000);
        vehicle1.setPassengerCapacity(2);
        vehicle2.setPassengerCapacity(2);
        assertEquals(0, new TaxiVehicleComparatorByPassengerAndLoad().compare(vehicle1, vehicle2));
    }
}