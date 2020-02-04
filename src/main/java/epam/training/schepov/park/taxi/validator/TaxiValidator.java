package epam.training.schepov.park.taxi.validator;

public class TaxiValidator {
    private static final int MIN_AUTO_LOAD_CAPACITY = 0;
    private static final int MAX_AUTO_LOAD_CAPACITY = 250;
    private static final int MIN_CARGO_LOAD_CAPACITY = 400;
    private static final int MAX_CARGO_LOAD_CAPACITY = 2000;
    private static final int MIN_MINIBUS_LOAD_CAPACITY = 0;
    private static final int MAX_MINIBUS_LOAD_CAPACITY = 500;

    private static final int MIN_AUTO_PASSENGERS = 1;
    private static final int MAX_AUTO_PASSENGERS= 6;
    private static final int MIN_CARGO_PASSENGERS = 0;
    private static final int MAX_CARGO_PASSENGERS = 3;
    private static final int MIN_MINIBUS_PASSENGERS = 7;
    private static final int MAX_MINIBUS_PASSENGERS = 12;

    public static boolean isValidAutoLoadCapacity(int loadCapacity){
        return loadCapacity <= MAX_AUTO_LOAD_CAPACITY && loadCapacity >= MIN_AUTO_LOAD_CAPACITY;
    }
    public static boolean isValidCargoLoadCapacity(int loadCapacity){
        return loadCapacity <= MAX_CARGO_LOAD_CAPACITY && loadCapacity >= MIN_CARGO_LOAD_CAPACITY;
    }
    public static boolean isValidMinibusLoadCapacity(int loadCapacity){
        return loadCapacity <= MAX_MINIBUS_LOAD_CAPACITY && loadCapacity >= MIN_MINIBUS_LOAD_CAPACITY;
    }

    public static boolean isValidAutoPassengerCapacity(int passengerCapacity){
        return passengerCapacity <= MAX_AUTO_PASSENGERS && passengerCapacity >= MIN_AUTO_PASSENGERS;
    }
    public static boolean isValidCargoPassengerCapacity(int passengerCapacity){
        return passengerCapacity <= MAX_CARGO_PASSENGERS && passengerCapacity >= MIN_CARGO_PASSENGERS;
    }
    public static boolean isValidMinibusPassengerCapacity(int passengerCapacity){
        return passengerCapacity <= MAX_MINIBUS_PASSENGERS && passengerCapacity >= MIN_MINIBUS_PASSENGERS;
    }
}
