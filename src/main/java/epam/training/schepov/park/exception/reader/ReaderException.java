package epam.training.schepov.park.exception.reader;

public class ReaderException extends RuntimeException {

  public ReaderException() {
  }

  public ReaderException(String message) {
    super(message);
  }

  public ReaderException(String message, Throwable cause) {
    super(message, cause);
  }

  public ReaderException(Throwable cause) {
    super(cause);
  }
}
