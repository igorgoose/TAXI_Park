package epam.training.schepov.park.repository.specification.impl.sort.comparator;

import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.Comparator;

public class TaxiVehicleComparatorByLoadAndPassenger implements Comparator<TaxiVehicle> {

    @Override
    public int compare(TaxiVehicle o1, TaxiVehicle o2) {
        return Comparator.comparingInt(TaxiVehicle::getLoadCapacity)
                .thenComparingInt(TaxiVehicle::getPassengerCapacity).compare(o1, o2);
    }

}
