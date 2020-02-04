package epam.training.schepov.park.entity.auto;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.brand.TaxiBrand;

import java.math.BigDecimal;

public class TaxiAuto extends TaxiVehicle {

    private static final int MIN_LOAD_CAPACITY = 0;
    private static final int MAX_LOAD_CAPACITY = 250;
    private static final int MIN_PASSENGER_CAPACITY = 1;
    private static final int MAX_PASSENGER_CAPACITY= 6;

    private static final BigDecimal DEFAULT_PRICE = new BigDecimal(4000);
    private static final int DEFAULT_PASSENGER_CAPACITY = 4;
    private static final int DEFAULT_LOAD_CAPACITY = 100;
    private static final LuxuryClass DEFAULT_LUXURY_CLASS = LuxuryClass.ECO;

    private LuxuryClass luxuryClass;


    public TaxiAuto(){
        price = DEFAULT_PRICE;
        passengerCapacity = DEFAULT_PASSENGER_CAPACITY;
        loadCapacity = DEFAULT_LOAD_CAPACITY;
        luxuryClass = DEFAULT_LUXURY_CLASS;
    }

    public TaxiAuto(BigDecimal price, int loadCapacity, int passengerCapacity,
                    TaxiBrand brand, LuxuryClass luxuryClass){
        super(price, loadCapacity, passengerCapacity, brand);
        this.luxuryClass = luxuryClass;
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

    public LuxuryClass getLuxuryClass() {
        return luxuryClass;
    }

    public void setLuxuryClass(LuxuryClass luxuryClass) {
        this.luxuryClass = luxuryClass;
    }
}
