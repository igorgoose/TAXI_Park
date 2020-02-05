package epam.training.schepov.park.specification.impl.sort.comparator;

import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.Comparator;

public class TaxiVehicleComparatorByPassengerAndLoad implements Comparator<TaxiVehicle>{
    @Override
    public int compare(TaxiVehicle o1, TaxiVehicle o2) {
        return Comparator.comparingInt(TaxiVehicle::getPassengerCapacity)
                .thenComparingInt(TaxiVehicle::getLoadCapacity).compare(o1, o2);
    }
}
