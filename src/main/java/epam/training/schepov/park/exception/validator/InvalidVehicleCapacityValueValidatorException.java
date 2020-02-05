package epam.training.schepov.park.exception.validator;

public class InvalidVehicleCapacityValueValidatorException extends Exception {

  public InvalidVehicleCapacityValueValidatorException() {
  }

  public InvalidVehicleCapacityValueValidatorException(String message) {
    super(message);
  }

  public InvalidVehicleCapacityValueValidatorException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidVehicleCapacityValueValidatorException(Throwable cause) {
    super(cause);
  }
}
