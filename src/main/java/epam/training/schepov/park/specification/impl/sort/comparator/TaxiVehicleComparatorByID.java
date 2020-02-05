package epam.training.schepov.park.specification.impl.sort.comparator;

import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.Comparator;

public class TaxiVehicleComparatorByID implements Comparator<TaxiVehicle> {

    @Override
    public int compare(TaxiVehicle o1, TaxiVehicle o2) {
        return o1.compareTo(o2);
    }
}
