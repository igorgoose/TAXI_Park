package epam.training.schepov.park.exception.entity;

public class TaxiVehicleUnsupportedOperationException extends RuntimeException {
    public TaxiVehicleUnsupportedOperationException() {
    }

    public TaxiVehicleUnsupportedOperationException(String message) {
        super(message);
    }

    public TaxiVehicleUnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaxiVehicleUnsupportedOperationException(Throwable cause) {
        super(cause);
    }
}
