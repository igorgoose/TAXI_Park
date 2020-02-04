package epam.training.schepov.park.exception.service;

public class InvalidVehicleCapacityValueServiceException extends Exception {
    public InvalidVehicleCapacityValueServiceException() {
    }

    public InvalidVehicleCapacityValueServiceException(String message) {
        super(message);
    }

    public InvalidVehicleCapacityValueServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidVehicleCapacityValueServiceException(Throwable cause) {
        super(cause);
    }
}
