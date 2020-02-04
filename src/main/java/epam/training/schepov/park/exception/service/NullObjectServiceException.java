package epam.training.schepov.park.exception.service;

public class NullObjectServiceException extends Exception {
    public NullObjectServiceException() {
    }

    public NullObjectServiceException(String message) {
        super(message);
    }

    public NullObjectServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullObjectServiceException(Throwable cause) {
        super(cause);
    }

}
