package epam.training.schepov.park.taxi;

import epam.training.schepov.park.taxi.brand.TaxiBrand;

import java.math.BigDecimal;

public abstract class TaxiVehicle {
    private static int current_id = 1;
    protected final int id;
    protected BigDecimal price;
    protected int passengerCapacity;
    protected int loadCapacity;
    protected TaxiBrand brand;

    protected TaxiVehicle() {
        id = current_id++;
    }



}
