package epam.training.schepov.park.entity.cargo;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.brand.TaxiBrand;

import java.math.BigDecimal;
import java.util.Objects;

public class TaxiCargo extends TaxiVehicle {
    private static final int MIN_LOAD_CAPACITY = 400;
    private static final int MAX_LOAD_CAPACITY = 2000;
    private static final int MIN_PASSENGER_CAPACITY = 0;
    private static final int MAX_PASSENGER_CAPACITY = 3;

    private static final BigDecimal DEFAULT_PRICE = new BigDecimal(15000);
    private static final int DEFAULT_PASSENGER_CAPACITY = 1;
    private static final int DEFAULT_LOAD_CAPACITY = 1000;
    private static final BodyType DEFAULT_BODY_TYPE = BodyType.CLOSED;

    private BodyType bodyType;

    public TaxiCargo(){
        price = DEFAULT_PRICE;
        passengerCapacity = DEFAULT_PASSENGER_CAPACITY;
        loadCapacity = DEFAULT_LOAD_CAPACITY;
        bodyType = DEFAULT_BODY_TYPE;
    }

    public TaxiCargo(BigDecimal price, int loadCapacity, int passengerCapacity,
                     TaxiBrand brand, BodyType bodyType){
        super(price, loadCapacity, passengerCapacity, brand);
        this.bodyType = bodyType;
    }

    @Override
    public int getMinLoadCapacity() {
        return MIN_LOAD_CAPACITY;
    }

    @Override
    public int getMaxLoadCapacity() {
        return MAX_LOAD_CAPACITY;
    }

    @Override
    public int getMinPassengerCapacity() {
        return MIN_PASSENGER_CAPACITY;
    }

    @Override
    public int getMaxPassengerCapacity() {
        return MAX_PASSENGER_CAPACITY;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TaxiCargo taxiCargo = (TaxiCargo) o;
        return bodyType == taxiCargo.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }

    @Override
    public String toString() {
        return "TaxiCargo{" +
                "bodyType=" + bodyType +
                ", id=" + id +
                ", price=" + price +
                ", passengerCapacity=" + passengerCapacity +
                ", loadCapacity=" + loadCapacity +
                ", brand=" + brand +
                '}';
    }

}
