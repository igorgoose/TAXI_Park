package epam.training.schepov.park.exception.validator;

public class NullObjectTaxiVehicleValidatorException extends Exception {

  public NullObjectTaxiVehicleValidatorException() {
  }

  public NullObjectTaxiVehicleValidatorException(String message) {
    super(message);
  }

  public NullObjectTaxiVehicleValidatorException(String message, Throwable cause) {
    super(message, cause);
  }

  public NullObjectTaxiVehicleValidatorException(Throwable cause) {
    super(cause);
  }
}
