package epam.training.schepov.park.entity;

import epam.training.schepov.park.entity.brand.TaxiBrand;

import java.math.BigDecimal;

public abstract class TaxiVehicle {
    private static int current_id = 1;
    protected final int id;
    protected BigDecimal price;
    protected int passengerCapacity;
    protected int loadCapacity;
    protected TaxiBrand brand;
    protected final TaxiBrand DEFAULT_BRAND = TaxiBrand.VOLKSWAGEN;

    protected TaxiVehicle() {
        id = current_id++;
        brand = DEFAULT_BRAND;
    }

    protected TaxiVehicle(BigDecimal price, int loadCapacity, int passengerCapacity, TaxiBrand brand){
        id = current_id++;
        this.price = price;
        this.loadCapacity = loadCapacity;
        this.passengerCapacity = passengerCapacity;
        this.brand = brand;
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
