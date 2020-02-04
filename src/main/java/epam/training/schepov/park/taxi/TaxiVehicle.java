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

    public BigDecimal getPrice(){
        return price;
    }

    public int getId() {
        return id;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public TaxiBrand getBrand() {
        return brand;
    }

    public abstract int getMinLoadCapacity();
    public abstract int getMaxLoadCapacity();
    public abstract int getMinPassengerCapacity();
    public abstract int getMaxPassengerCapacity();

}
