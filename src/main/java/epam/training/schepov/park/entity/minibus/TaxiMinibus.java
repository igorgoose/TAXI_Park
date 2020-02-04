package epam.training.schepov.park.entity.minibus;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.auto.LuxuryClass;
import epam.training.schepov.park.entity.brand.TaxiBrand;

import java.math.BigDecimal;

public class TaxiMinibus extends TaxiVehicle {
    private static final int MIN_LOAD_CAPACITY = 0;
    private static final int MAX_LOAD_CAPACITY = 500;
    private static final int MIN_PASSENGER_CAPACITY = 7;
    private static final int MAX_PASSENGER_CAPACITY = 12;

    private static final BigDecimal DEFAULT_PRICE = new BigDecimal(12000);
    private static final int DEFAULT_PASSENGER_CAPACITY = 9;
    private static final int DEFAULT_LOAD_CAPACITY = 100;
    private static final RideRegion DEFAULT_RIDE_REGION = RideRegion.WITHIN_CITY;

    private RideRegion rideRegion;

    public TaxiMinibus(){
        price = DEFAULT_PRICE;
        passengerCapacity = DEFAULT_PASSENGER_CAPACITY;
        loadCapacity = DEFAULT_LOAD_CAPACITY;
        rideRegion = DEFAULT_RIDE_REGION;
    }

    public TaxiMinibus(BigDecimal price, int loadCapacity, int passengerCapacity,
                    TaxiBrand brand, RideRegion rideRegion){
        super(price, loadCapacity, passengerCapacity, brand);
        this.rideRegion = rideRegion;
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

    public void setRideRegion(RideRegion rideRegion) {
        this.rideRegion = rideRegion;
    }

    public RideRegion getRideRegion() {
        return rideRegion;
    }

}
