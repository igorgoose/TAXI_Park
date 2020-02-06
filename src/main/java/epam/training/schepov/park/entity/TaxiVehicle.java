package epam.training.schepov.park.entity;

import epam.training.schepov.park.entity.brand.TaxiBrand;
import epam.training.schepov.park.exception.entity.TaxiVehicleUnsupportedOperationException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Objects;

public abstract class TaxiVehicle implements Serializable, Comparable<TaxiVehicle> {
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public void setBrand(TaxiBrand brand) {
        this.brand = brand;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaxiVehicle that = (TaxiVehicle) o;
        return id == that.id &&
            passengerCapacity == that.passengerCapacity &&
            loadCapacity == that.loadCapacity &&
            Objects.equals(price, that.price) &&
            brand == that.brand &&
            DEFAULT_BRAND == that.DEFAULT_BRAND;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, passengerCapacity, loadCapacity, brand, DEFAULT_BRAND);
    }

    @Override
    public String toString() {
        return "TaxiVehicle{" +
                "id=" + id +
                ", price=" + price +
                ", passengerCapacity=" + passengerCapacity +
                ", loadCapacity=" + loadCapacity +
                ", brand=" + brand +
                '}';
    }

    @Override
    public int compareTo(TaxiVehicle o) {
        return id - o.id;
    }

}
