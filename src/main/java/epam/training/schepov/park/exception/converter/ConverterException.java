package epam.training.schepov.park.exception.converter;

public class ConverterException extends Exception {

  public ConverterException() {
  }

  public ConverterException(String message) {
    super(message);
  }

  public ConverterException(String message, Throwable cause) {
    super(message, cause);
  }

  public ConverterException(Throwable cause) {
    super(cause);
  }
}
